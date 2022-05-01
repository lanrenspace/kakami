package com.lanrenspace.kakami.service.imp;

import com.lanrenspace.kakami.base.impl.BaseBeanServiceImpl;
import com.lanrenspace.kakami.entity.DictionaryType;
import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import com.lanrenspace.kakami.mapper.DictionaryTypeMapper;
import com.lanrenspace.kakami.service.DictionaryTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Slf4j
@Service
public class DictionaryTypeServiceImpl extends BaseBeanServiceImpl<DictionaryType, DictionaryTypeMapper> implements DictionaryTypeService {

    /**
     * 创建字典类型
     *
     * @param dictionaryTypeMono 字典类型信息
     * @return
     */
    @Override
    public Mono<String> createDictionaryType(Mono<DictionaryType> dictionaryTypeMono) {
        return dictionaryTypeMono.switchIfEmpty(Mono.error(new ServiceException(ExceptionDef.PARAMS_IS_NULL))).flatMap(dictionaryType -> {
            dictionaryType.setCreateTime(LocalDateTime.now());
            dictionaryType.setDeleteFlag(false);
            getMapper().insert(Mono.just(dictionaryType));
            return Mono.just(dictionaryType.getCode());
        });
    }
}
