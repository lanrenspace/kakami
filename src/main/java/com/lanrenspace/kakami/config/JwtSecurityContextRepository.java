package com.lanrenspace.kakami.config;

import cn.hutool.jwt.JWT;
import com.lanrenspace.kakami.base.RedisUtils;
import com.lanrenspace.kakami.constant.SysCont;
import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description: 获取请求头中带过来的token值，解析并验证用户信息
 **/
@Slf4j
public class JwtSecurityContextRepository implements ServerSecurityContextRepository {

    private final RedisUtils redisUtils;

    public JwtSecurityContextRepository(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        return Mono.empty();
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().toString();
        log.info("load token...................");
        log.info("path: {}", path);
        if ("/login".equals(path)) {
            return Mono.empty();
        }
        if ("/openApi/register".equals(path)) {
            return this.buildAnonymousSecurityContext();
        }
        String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (ObjectUtils.isEmpty(token)) {
            return Mono.error(new ServiceException(ExceptionDef.REQ_TOKEN_IS_NULL));
        }
        if (!token.startsWith(SysCont.TOKEN_TYPE)) {
            return Mono.error(new ServiceException(ExceptionDef.REQ_TOKEN_FORMAT_ERROR));
        }
        token = token.substring(token.indexOf(SysCont.TOKEN_TYPE) + 1);
        String userAccount = JWT.of(token).setKey(SysCont.JWT_KEY).getPayload(JWT.SUBJECT).toString();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userAccount, userAccount);
        return redisUtils.hasKey(userAccount).flatMap(aBoolean -> {
            if (!aBoolean) {
                return Mono.error(new ServiceException(ExceptionDef.USER_NOT_EXIST));
            }
            return Mono.just(new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getAuthorities()));
        }).map(SecurityContextImpl::new);
    }


    /**
     * 构建匿名授权
     */
    private Mono<SecurityContext> buildAnonymousSecurityContext() {
        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("NONE"));
        return Mono.just(new SecurityContextImpl(new AnonymousAuthenticationToken("anonymous", "anonymous", auths)));
    }
}
