package com.lanrenspace.kakami.mapper;

import com.lanrenspace.kakami.base.IBaseBeanMapper;
import com.lanrenspace.kakami.entity.DictionaryItem;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface DictionaryItemMapper extends IBaseBeanMapper<DictionaryItem> {

    /**
     * 新增
     *
     * @param dictionaryItemMono
     * @return
     */
    Mono<Long> insert(Mono<DictionaryItem> dictionaryItemMono);

    /**
     * 根据条件查询
     *
     * @param dictionaryItemMono
     * @return
     */
    Flux<DictionaryItem> selectByCondition(Mono<DictionaryItem> dictionaryItemMono);
}
