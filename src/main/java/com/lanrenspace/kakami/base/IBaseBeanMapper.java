package com.lanrenspace.kakami.base;


import java.lang.reflect.ParameterizedType;

/**
 * @Author lanrenspace@163.com
 * @Description: 基础mapper
 **/
public interface IBaseBeanMapper<T extends DataEntity<T>> {


    /**
     * 获取mapper 实现
     * @return
     */
    default Class<T> getMapperClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
