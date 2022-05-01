package com.lanrenspace.kakami.config;

import com.alibaba.fastjson.JSONObject;
import com.lanrenspace.kakami.base.IFillRuleHandler;
import com.lanrenspace.kakami.base.RedisUtils;
import com.lanrenspace.kakami.config.ApplicationContextHelper;
import com.lanrenspace.kakami.constant.SysCont;
import com.lanrenspace.kakami.entity.DictionaryItem;
import com.lanrenspace.kakami.entity.DictionaryType;
import com.lanrenspace.kakami.service.DictionaryItemService;
import com.lanrenspace.kakami.service.DictionaryTypeService;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lanrenspace@163.com
 * @Description: 规则生成填充工具
 **/
@Component
public class FillRuleUtil {

    private RedisUtils redisUtils;
    private DictionaryItemService dictionaryItemService;
    private DictionaryTypeService dictionaryTypeService;

    public FillRuleUtil(RedisUtils redisUtils, DictionaryItemService dictionaryItemService, DictionaryTypeService dictionaryTypeService) {
        this.redisUtils = redisUtils;
        this.dictionaryItemService = dictionaryItemService;
        this.dictionaryTypeService = dictionaryTypeService;
    }

    /**
     * 执行策略
     *
     * @param ruleCode
     * @param formData
     * @return
     */
    public Mono<Object> executeRule(String ruleCode, JSONObject formData) {
        if (ObjectUtils.isEmpty(ruleCode)) {
            return null;
        }
        return this.redisUtils.get(SysCont.FILL_RULE_CODE).flatMap(o -> {
            List<DictionaryItem> items = (List<DictionaryItem>) o;
            return Mono.just(items.parallelStream().filter(dictionaryItem -> ruleCode.equals(dictionaryItem.getItemCode())).findFirst().get());
        }).flatMap(dictionaryItem -> {
            try {
                IFillRuleHandler fillRuleHandler = (IFillRuleHandler) Class.forName(dictionaryItem.getItemValue()).newInstance();
                return fillRuleHandler.execute(null, formData);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return Mono.empty();
        });
    }

    /**
     * 注册
     *
     * @param ruleCode
     * @param fillRuleHandler
     */
    public void register(String ruleCode, IFillRuleHandler fillRuleHandler) {
        DictionaryType dictionaryType = new DictionaryType();
        dictionaryType.setCode(SysCont.FILL_RULE_CODE);
        dictionaryType.setName("自定义填充规则实现");
        dictionaryType.setItemScope("system");
        dictionaryType.setUpdatable(false);
        dictionaryType.setTenantCode(SysCont.SYS_TENANT_CODE);
        this.dictionaryTypeService.createDictionaryType(Mono.just(dictionaryType)).flatMap(dictionaryTypeCode -> {
            DictionaryItem dictionaryItem = new DictionaryItem();
            dictionaryItem.setItemCode(ruleCode);
            dictionaryItem.setItemValue(fillRuleHandler.getClass().getName());
            dictionaryItem.setTenantCode(SysCont.SYS_TENANT_CODE);
            dictionaryItem.setUpdatable(false);
            return this.dictionaryItemService.createDictionaryItem(Mono.just(dictionaryTypeCode), Mono.just(dictionaryItem));
        }).flatMap(dictionaryItem -> this.dictionaryItemService.getAllItemByDictionaryCode(dictionaryItem.getDictionaryCode()).collectList().flatMap(dictionaryItems -> {
            this.redisUtils.setNeverExpires(dictionaryItem.getDictionaryCode(), dictionaryItems);
            return Mono.empty();
        }).then());
    }
}
