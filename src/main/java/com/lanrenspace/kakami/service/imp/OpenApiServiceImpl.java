package com.lanrenspace.kakami.service.imp;

import cn.hutool.jwt.JWT;
import com.lanrenspace.kakami.base.RedisUtils;
import com.lanrenspace.kakami.base.ResultData;
import com.lanrenspace.kakami.constant.SysCont;
import com.lanrenspace.kakami.dto.RegisterDTO;
import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import com.lanrenspace.kakami.service.OpenApiService;
import com.lanrenspace.kakami.service.TenantInfoService;
import com.lanrenspace.kakami.service.UserInfoService;
import com.lanrenspace.kakami.validator.ReqValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Slf4j
@Service
public class OpenApiServiceImpl implements OpenApiService {

    private RedisUtils redisUtils;
    private UserInfoService userInfoService;
    private TenantInfoService tenantInfoService;

    @Autowired
    private R2dbcTransactionManager transactionManager;

    public OpenApiServiceImpl(RedisUtils redisUtils, UserInfoService userInfoService, TenantInfoService tenantInfoService) {
        this.redisUtils = redisUtils;
        this.userInfoService = userInfoService;
        this.tenantInfoService = tenantInfoService;
    }

    /**
     * 注册
     *
     * @param serverRequest
     * @return
     */
    @Override
    public Mono<ServerResponse> register(ServerRequest serverRequest) {
        TransactionalOperator rxtx = TransactionalOperator.create(transactionManager);
        log.info("register req");
        return serverRequest.bodyToMono(RegisterDTO.class)
                .doOnNext(ReqValidator::registerDTO)
                .flatMap(registerDTO -> userInfoService.getUserInfoByAccount(registerDTO.getEmail().trim())
                        .flatMap(userInfo -> ResultData.fail(ExceptionDef.USER_EMAIL_EXIST))
                        .switchIfEmpty(tenantInfoService.createTenant(registerDTO).flatMap(ResultData::success)).as(rxtx::transactional))
                .switchIfEmpty(ResultData.fail(ExceptionDef.REQ_PARAMS_IS_NULL)).as(rxtx::transactional).then(ResultData.success(""));
    }

    /**
     * 创建令牌
     *
     * @param userAccount
     * @return
     */
    @Override
    public Mono<String> createToken(String userAccount) {
        if (ObjectUtils.isEmpty(userAccount)) {
            throw new ServiceException(ExceptionDef.PARAMS_IS_NULL);
        }
        String key = String.format(SysCont.JWT_STORE_KEY, userAccount);
        return redisUtils.hasKey(key).flatMap(aBoolean -> {
            if (aBoolean) {
                return redisUtils.get(key).map(Object::toString);
            }
            String token = JWT.create().setKey(SysCont.JWT_KEY).setPayload(JWT.SUBJECT, userAccount).sign();
            log.info("userAccount token expiresAt:{}", JWT.of(token).getPayload(JWT.EXPIRES_AT));
            redisUtils.set(key, token, Duration.ofSeconds(1800));
            return Mono.just(token);
        }).switchIfEmpty(Mono.error(new ServiceException(ExceptionDef.CREATE_TOKEN_EXCEPTION)));
    }

    /**
     * 验证令牌
     *
     * @param userAccount
     * @return
     */
    @Override
    public String verifyToken(String userAccount) {
        return null;
    }
}
