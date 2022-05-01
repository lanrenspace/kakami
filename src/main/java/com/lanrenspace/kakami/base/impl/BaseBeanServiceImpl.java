package com.lanrenspace.kakami.base.impl;

import com.lanrenspace.kakami.base.DataEntity;
import com.lanrenspace.kakami.base.IBaseBeanMapper;
import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.config.ApplicationContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.r2dbc.ReactiveSqlSession;
import org.apache.ibatis.r2dbc.ReactiveSqlSessionFactory;
import org.springframework.beans.factory.InitializingBean;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Slf4j
public class BaseBeanServiceImpl<T extends DataEntity<T>, D extends IBaseBeanMapper<T>> implements IBaseBeanService<T, D>, InitializingBean {

    /**
     * 业务对象
     */
    private Class<T> beanClass;

    private static ReactiveSqlSession reactiveSqlSession;

    static {
        if (null == reactiveSqlSession) {
            reactiveSqlSession = ApplicationContextHelper.getBean(ReactiveSqlSessionFactory.class).openSession();
        }
    }

    @Override
    public <T1> Mono<T1> getByPk() {
        return null;
    }

    @Override
    public Class<T> getBeanClass() {
        return this.beanClass;
    }

    @Override
    public D getMapper() {

        log.info("reactiveSqlSession:" + this.reactiveSqlSession);
        Class<T> typeArgument = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return (D) this.reactiveSqlSession.getMapper(typeArgument);
    }

    @Override
    public void afterPropertiesSet() {
        if ((getClass().getGenericSuperclass() instanceof ParameterizedType)) {
            this.beanClass = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
    }
}
