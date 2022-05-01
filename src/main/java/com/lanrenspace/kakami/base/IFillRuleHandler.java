package com.lanrenspace.kakami.base;

import com.alibaba.fastjson.JSONObject;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description: 填充规则接口
 **/
@FunctionalInterface
public interface IFillRuleHandler {

    /**
     * 规则实现
     *
     * @param params   页面配置固定参数
     * @param formData 动态表单参数
     * @return
     */
    Mono<Object> execute(JSONObject params, JSONObject formData);
}
