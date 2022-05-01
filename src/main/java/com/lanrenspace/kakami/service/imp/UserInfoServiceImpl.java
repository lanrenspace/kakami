package com.lanrenspace.kakami.service.imp;

import com.lanrenspace.kakami.base.impl.BaseBeanServiceImpl;
import com.lanrenspace.kakami.dto.RegisterDTO;
import com.lanrenspace.kakami.entity.UserInfo;
import com.lanrenspace.kakami.mapper.UserInfoMapper;
import com.lanrenspace.kakami.service.UserInfoService;
import com.lanrenspace.kakami.utils.AssertUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Service
public class UserInfoServiceImpl extends BaseBeanServiceImpl<UserInfo, UserInfoMapper> implements UserInfoService {

    /**
     * 根据用户账号获取用户信息
     *
     * @param userAccount
     * @return
     */
    @Override
    public Mono<UserInfo> getUserInfoByAccount(String userAccount) {
        AssertUtils.isEmpty(userAccount);
        return getMapper().selectByUserAccount(userAccount);
    }

    /**
     * 创建用户信息
     *
     * @param registerDTO
     * @return
     */
    @Override
    public Mono<String> createUserInfo(RegisterDTO registerDTO) {
        return null;
    }

    /**
     * 创建用户信息
     *
     * @param userInfoMono
     * @return
     */
    @Override
    public Mono<String> createUserInfo(Mono<UserInfo> userInfoMono) {
        return userInfoMono.flatMap(userInfo -> {
            userInfo.setCreateTime(LocalDateTime.now());
            userInfo.setValidFlag(true);
            return getMapper().insert(Mono.just(userInfo)).flatMap(id -> Mono.just(userInfo.getUserAccount()));
        });
    }

}
