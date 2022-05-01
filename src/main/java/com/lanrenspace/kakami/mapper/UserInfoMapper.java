package com.lanrenspace.kakami.mapper;

import com.lanrenspace.kakami.base.IBaseBeanMapper;
import com.lanrenspace.kakami.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import reactor.core.publisher.Mono;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface UserInfoMapper extends IBaseBeanMapper<UserInfo> {

    /**
     * 根据账号查询用户信息
     *
     * @param userAccount
     * @return
     */
    Mono<UserInfo> selectByUserAccount(@Param("userAccount") String userAccount);

    /**
     * 新增
     *
     * @param userInfoMono
     * @return
     */
    Mono<Long> insert(Mono<UserInfo> userInfoMono);
}
