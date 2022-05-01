package com.lanrenspace.kakami.config;

import org.springframework.cglib.beans.BeanMap;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @Author lanrenspace@163.com
 * @Description: 获取当前请求用户信息工具
 **/
public class UserUtil {

    /**
     * token类型头
     */
    private static final String TOKEN_TYPE = "Bearer ";

    /**
     * 获取当前用户(从上下文中获取)
     *
     * @return
     */
    public static Mono<SecurityUserInfo> getUserInfo() {
        Mono<SecurityContext> context = ReactiveSecurityContextHolder.getContext();
        Mono<Authentication> authentication = context.filter(c -> c.getAuthentication() != null)
                .map(SecurityContext::getAuthentication);
        return authentication.flatMap(auth -> {
            Jwt credentials = (Jwt) auth.getCredentials();
            Map<String, Object> claims = credentials.getClaims();
            SecurityUserInfo securityUser = new SecurityUserInfo();
            BeanMap beanMap = BeanMap.create(securityUser);
            beanMap.putAll(claims);
            securityUser.setToken(TOKEN_TYPE + credentials.getTokenValue());
            return Mono.just(securityUser);
        });
    }

}
