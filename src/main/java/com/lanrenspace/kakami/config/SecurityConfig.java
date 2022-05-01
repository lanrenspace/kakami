package com.lanrenspace.kakami.config;

import cn.hutool.jwt.JWT;
import com.alibaba.fastjson.JSONObject;
import com.lanrenspace.kakami.base.RedisUtils;
import com.lanrenspace.kakami.config.handler.AccessDeniedHandler;
import com.lanrenspace.kakami.config.handler.AuthenticationFailHandler;
import com.lanrenspace.kakami.config.handler.AuthenticationSuccessHandler;
import com.lanrenspace.kakami.config.handler.LogoutSuccessHandler;
import com.lanrenspace.kakami.constant.SysCont;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Slf4j
@EnableWebFluxSecurity
public class SecurityConfig {

    /*@Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http.authorizeExchange()
                .pathMatchers("/tenantInfo/tenantInfoList").permitAll()
                .pathMatchers("/message/**").hasAuthority("SCOPE_message:read").anyExchange()
                .authenticated().and().oauth2ResourceServer().jwt();
        http.csrf().disable();
        return http.build();
    }

    @Bean
    ReactiveJwtDecoder reactiveJwtDecoder() {
        return new NimbusReactiveJwtDecoder("http://localhost:8760/apis/uaa/.well-known/jwks.json");
    }*/


    /**
     * 提供用于获取UserDetails的Service
     *
     * @param userService
     * @return
     */
    @Bean
    public ReactiveAuthenticationManager authenticationManager(UserService userService) {
        log.info("load security userDetail config....................");
        return new UserDetailsRepositoryReactiveAuthenticationManager(userService);
    }


    /**
     * http请求路径权限与过滤链配置
     *
     * @param httpSecurity
     * @param redisUtils
     * @return
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity, RedisUtils redisUtils) {
        log.info("load security webFilterChain.....................");
        httpSecurity.csrf().disable().cors().disable().httpBasic().disable()
                .securityContextRepository(new JwtSecurityContextRepository(redisUtils))
                .formLogin()
                .authenticationFailureHandler(new AuthenticationFailHandler())
                .loginPage("/login")
                .authenticationSuccessHandler(new AuthenticationSuccessHandler())
                .and()
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .pathMatchers("/login", "/openApi/register").permitAll()
                .anyExchange()
                .authenticated()
                .and().logout().logoutSuccessHandler(new LogoutSuccessHandler())
                .and().exceptionHandling().accessDeniedHandler(new AccessDeniedHandler());
        return httpSecurity.build();

    }
}
