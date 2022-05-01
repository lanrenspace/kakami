package com.lanrenspace.kakami.mapper;

import com.lanrenspace.kakami.base.IBaseBeanMapper;
import com.lanrenspace.kakami.entity.DictionaryType;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface DictionaryTypeMapper extends IBaseBeanMapper<DictionaryType> {

    /**
     * 新增
     * @param dictionaryTypeMono
     * @return
     */
    Mono<Long> insert(Mono<DictionaryType> dictionaryTypeMono);
}
