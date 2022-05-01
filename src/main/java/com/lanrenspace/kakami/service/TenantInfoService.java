package com.lanrenspace.kakami.service;

import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.dto.RegisterDTO;
import com.lanrenspace.kakami.entity.TenantInfo;
import com.lanrenspace.kakami.mapper.TenantInfoReactiveMapper;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description: 租户业务处理
 **/
public interface TenantInfoService extends IBaseBeanService<TenantInfo, TenantInfoReactiveMapper> {

    /**
     * 获取列表
     *
     * @return
     */
    Mono<ServerResponse> getList(ServerRequest serverRequest);

    /**
     * 创建租户
     *
     * @param registerDTO
     * @return 租户编码
     */
    Mono<String> createTenant(RegisterDTO registerDTO);
}
