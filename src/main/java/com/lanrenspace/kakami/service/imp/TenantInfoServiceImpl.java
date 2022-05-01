package com.lanrenspace.kakami.service.imp;

import com.lanrenspace.kakami.base.ResultData;
import com.lanrenspace.kakami.base.impl.BaseBeanServiceImpl;
import com.lanrenspace.kakami.dto.RegisterDTO;
import com.lanrenspace.kakami.entity.TenantInfo;
import com.lanrenspace.kakami.entity.UserInfo;
import com.lanrenspace.kakami.mapper.TenantInfoReactiveMapper;
import com.lanrenspace.kakami.service.TenantInfoService;
import com.lanrenspace.kakami.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Slf4j
@Service
public class TenantInfoServiceImpl extends BaseBeanServiceImpl<TenantInfo, TenantInfoReactiveMapper> implements TenantInfoService {

    @Autowired
    private UserInfoService userInfoService;


    @Override
    public Mono<ServerResponse> getList(ServerRequest serverRequest) {
        Mono<TenantInfo> tenantInfoMono = this.getMapper().selectList();
        Mono<ResultData> resultDataMono = tenantInfoMono.flatMap(tenantInfo -> Mono.just(ResultData.ok(tenantInfo)));
        return ResultData.success(resultDataMono);
    }

    /**
     * 创建租户
     *
     * @param registerDTO
     * @return 租户编码
     */
    @Override
    public Mono<String> createTenant(RegisterDTO registerDTO) {
        log.info("create tenant....");
        TenantInfo tenantInfo = new TenantInfo();
        tenantInfo.setId(1000l);
        String email = registerDTO.getEmail();
        tenantInfo.setAdminCode(email);
        tenantInfo.setTenantCode("10002");
        tenantInfo.setTenantName(email);
        tenantInfo.setAdminAccount(email);
        tenantInfo.setAdminName(email);
        tenantInfo.setAuditTime(LocalDateTime.now());
        tenantInfo.setValidFlag(true);
        tenantInfo.setDeleteFlag(false);
        tenantInfo.setCreateTime(LocalDateTime.now());
        return getMapper().insert(tenantInfo).flatMap(id -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserCode(email);
            userInfo.setUserAccount(email);
            userInfo.setTenantCode(tenantInfo.getTenantCode());
            return userInfoService.createUserInfo(Mono.just(userInfo));
        });
    }
}
