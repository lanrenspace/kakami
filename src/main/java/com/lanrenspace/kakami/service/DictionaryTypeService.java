package com.lanrenspace.kakami.service;

import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.entity.DictionaryType;
import com.lanrenspace.kakami.mapper.DictionaryTypeMapper;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface DictionaryTypeService extends IBaseBeanService<DictionaryType, DictionaryTypeMapper> {

    /**
     * 创建字典类型
     * @param dictionaryTypeMono 字典类型信息
     * @return
     */
    Mono<String> createDictionaryType(Mono<DictionaryType> dictionaryTypeMono);
}
