package com.lanrenspace.kakami.service;

import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.entity.DictionaryItem;
import com.lanrenspace.kakami.mapper.DictionaryItemMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface DictionaryItemService extends IBaseBeanService<DictionaryItem, DictionaryItemMapper> {


    /**
     * 创建字典项
     *
     * @param dictionaryTypeCode
     * @param dictionaryItemMono
     * @return
     */
    Mono<DictionaryItem> createDictionaryItem(Mono<String> dictionaryTypeCode, Mono<DictionaryItem> dictionaryItemMono);

    /**
     * 根据字典类型获取所有字典项
     *
     * @param dictionaryCode
     * @return
     */
    Flux<DictionaryItem> getAllItemByDictionaryCode(String dictionaryCode);
}
