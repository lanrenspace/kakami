package com.lanrenspace.kakami.routers;

import com.lanrenspace.kakami.service.TenantInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author lanrenspace@163.com
 * @Description: 租户服务
 **/
@Configuration
public class TenantInfoRouters {

    /**
     * 根路径
     */
    private static final String ROOT_PATTERN = "/tenantInfo";

    @Bean
    public RouterFunction<ServerResponse> tenantInfoRouter(TenantInfoService tenantInfoService) {
        return RouterFunctions.route(RequestPredicates.GET(ROOT_PATTERN + "/tenantInfoList").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), tenantInfoService::getList);
    }
}
