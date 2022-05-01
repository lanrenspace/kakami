package com.lanrenspace.kakami.mapper;

import com.lanrenspace.kakami.base.IBaseBeanMapper;
import com.lanrenspace.kakami.entity.TenantInfo;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description: 租户信息
 **/
public interface TenantInfoReactiveMapper extends IBaseBeanMapper<TenantInfo> {

    /**
     * 查询租户列表
     *
     * @return
     */
    Mono<TenantInfo> selectList();

    /**
     * 新增
     *
     * @param tenantInfo
     * @return
     */
    Mono<Long> insert(TenantInfo tenantInfo);
}
