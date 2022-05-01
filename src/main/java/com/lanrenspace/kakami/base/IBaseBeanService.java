package com.lanrenspace.kakami.base;

import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface IBaseBeanService<T extends DataEntity<T>,D extends IBaseBeanMapper<T>> {

    /**
     * 根据ID主键获取
     *
     * @param <T>
     * @return
     */
    <T> Mono<T> getByPk();


    /**
     * 获取业务对象
     * @return
     */
    Class<T> getBeanClass();

    /**
     * 获取mapper对象
     * @return
     */
    D getMapper();
}
