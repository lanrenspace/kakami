package com.lanrenspace.kakami.service.imp;

import com.lanrenspace.kakami.base.impl.BaseBeanServiceImpl;
import com.lanrenspace.kakami.entity.DictionaryItem;
import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import com.lanrenspace.kakami.mapper.DictionaryItemMapper;
import com.lanrenspace.kakami.service.DictionaryItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Slf4j
@Service
public class DictionaryItemServiceImpl extends BaseBeanServiceImpl<DictionaryItem, DictionaryItemMapper> implements DictionaryItemService {
    /**
     * 创建字典项
     *
     * @param dictionaryTypeCode
     * @param dictionaryItemMono
     * @return
     */
    @Override
    public Mono<DictionaryItem> createDictionaryItem(Mono<String> dictionaryTypeCode, Mono<DictionaryItem> dictionaryItemMono) {
        return dictionaryTypeCode.switchIfEmpty(Mono.error(new ServiceException(ExceptionDef.PARAMS_IS_NULL))).flatMap(dicTypeCode -> {
            Mono<DictionaryItem> itemMono = dictionaryItemMono.switchIfEmpty(Mono.error(new ServiceException(ExceptionDef.PARAMS_IS_NULL))).map(dictionaryItem -> {
                dictionaryItem.setCreateTime(LocalDateTime.now());
                dictionaryItem.setDictionaryCode(dicTypeCode);
                return dictionaryItem;
            });
            getMapper().insert(itemMono);
            return itemMono;
        });
    }

    /**
     * 根据字典类型获取所有字典项
     *
     * @param dictionaryCode
     * @return
     */
    @Override
    public Flux<DictionaryItem> getAllItemByDictionaryCode(String dictionaryCode) {
        if (ObjectUtils.isEmpty(dictionaryCode)) {
            throw new ServiceException(ExceptionDef.PARAMS_IS_NULL);
        }
        DictionaryItem dictionaryItem = new DictionaryItem();
        dictionaryItem.setDictionaryCode(dictionaryCode);
        return getMapper().selectByCondition(Mono.just(dictionaryItem));
    }
}
