package com.lanrenspace.kakami.service;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description: 开放接口处理
 **/
public interface OpenApiService {

    /**
     * 注册
     * @param serverRequest
     * @return
     */
    Mono<ServerResponse> register(ServerRequest serverRequest);

    /**
     * 创建令牌
     *
     * @param userAccount
     * @return
     */
    Mono<String> createToken(String userAccount);

    /**
     * 验证令牌
     *
     * @param userAccount
     * @return
     */
    String verifyToken(String userAccount);
}
