package com.lanrenspace.kakami.config;

import com.lanrenspace.kakami.exceptions.ExceptionDef;
import com.lanrenspace.kakami.exceptions.ServiceException;
import com.lanrenspace.kakami.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author lanrenspace@163.com
 * @Description: 用户信息查询与登录状态保存
 **/
@Service
public class UserService implements ReactiveUserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userInfoService.getUserInfoByAccount(username).flatMap(userInfo -> {
            UserDetails userDetails = new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return new ArrayList<>();
                }

                @Override
                public String getPassword() {
                    return userInfo.getPassword();
                }

                @Override
                public String getUsername() {
                    return userInfo.getUserAccount();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
            return Mono.just(userDetails);
        }).switchIfEmpty(Mono.error(new ServiceException(ExceptionDef.USER_NOT_EXIST)));
    }
}
