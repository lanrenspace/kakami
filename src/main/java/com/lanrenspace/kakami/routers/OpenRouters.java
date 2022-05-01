package com.lanrenspace.kakami.routers;

import com.lanrenspace.kakami.base.ServerRouters;
import com.lanrenspace.kakami.service.OpenApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author lanrenspace@163.com
 * @Description: 开放 API 接口
 **/
@Configuration
public class OpenRouters extends ServerRouters {

    public OpenRouters() {
        super("/openApi");
    }

    @Bean
    public RouterFunction<ServerResponse> openApiRouters(OpenApiService openApiService) {
        return this.buildGetRoute("/register", openApiService::register);
    }
}
