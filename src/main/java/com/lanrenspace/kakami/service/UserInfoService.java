package com.lanrenspace.kakami.service;

import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.dto.RegisterDTO;
import com.lanrenspace.kakami.entity.UserInfo;
import com.lanrenspace.kakami.mapper.UserInfoMapper;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface UserInfoService extends IBaseBeanService<UserInfo, UserInfoMapper> {

    /**
     * 根据用户账号获取用户信息
     *
     * @param userAccount
     * @return
     */
    Mono<UserInfo> getUserInfoByAccount(String userAccount);

    /**
     * 创建用户信息
     *
     * @param registerDTO
     * @return
     */
    Mono<String> createUserInfo(RegisterDTO registerDTO);

    /**
     * 创建用户信息
     *
     * @param userInfoMono
     * @return
     */
    Mono<String> createUserInfo(Mono<UserInfo> userInfoMono);
}
