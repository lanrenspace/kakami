package com.lanrenspace.kakami.config;

import com.lanrenspace.kakami.base.ServerUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public class SecurityUserInfo implements UserDetails, ServerUser {

    /**
     * 账号过期
     */
    private boolean accountNonExpired;

    /**
     * 账号锁定
     */
    private boolean accountNonLocked;

    /**
     * 证书过期
     */
    private boolean credentialsNonExpired;

    /**
     * 是否启用
     */
    private boolean enabled;


    /**
     * ip 地址
     */
    private String ip;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户账号
     */
    private String userAccount;


    /**
     * 用户密码
     */
    private String password;

    /**
     * oauth2 token
     */
    private String token;

    /**
     * 租户编码
     */
    private String tenantCode;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 用户手机号
     */
    private String userMobile;

    /**
     * 机构名称
     */
    private String unitName;

    /**
     * 机构编码
     */
    private String unitCode;

    /**
     * 机构ID
     */
    private Long unitId;

    /**
     * 租户管理机构
     */
    private boolean tenantAdminUnit;

    /**
     * 租户管理员
     */
    private boolean tenantAdmin;

    /**
     * 平台管理员
     */
    private boolean admin;

    /**
     * 用户角色
     */
    private List<String> roles;

    public SecurityUserInfo() {
    }

    public SecurityUserInfo(String userAccount, String password, boolean enabled, boolean accountNonExpired,
                            boolean credentialsNonExpired, boolean accountNonLocked) {
        this.userAccount = userAccount;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
    }


    /**
     * 获取用户名称
     *
     * @return
     */
    @Override
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName
     */
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户账号
     *
     * @return
     */
    @Override
    public String getUserAccount() {
        return this.userAccount;
    }

    /**
     * 设置用户账号
     *
     * @param userAccount
     */
    @Override
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取登录IP
     *
     * @return
     */
    @Override
    public String getIp() {
        return this.ip;
    }

    /**
     * 设置登录IP
     *
     * @param ip
     */
    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 是否启用
     *
     * @param enabled
     */
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取角色列表
     *
     * @return
     */
    @Override
    public List<String> getRoles() {
        return this.roles;
    }

    /**
     * 设置角色信息
     *
     * @param roles
     */
    @Override
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    /**
     * 是否未过期
     *
     * @param accountNonExpired
     */
    @Override
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * 是否未锁定
     *
     * @param accountNonLocked
     */
    @Override
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * 证书是否未过期
     *
     * @param credentialsNonExpired
     */
    @Override
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * 获取token
     *
     * @return
     */
    @Override
    public String getToken() {
        return this.token;
    }

    /**
     * 设置token
     *
     * @param token
     */
    @Override
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取租户编码
     *
     * @return
     */
    @Override
    public String getTenantCode() {
        return this.tenantCode;
    }

    /**
     * 设置租户编码
     *
     * @param tenantCode
     */
    @Override
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    /**
     * 获取用户ID
     *
     * @return
     */
    @Override
    public Long getUserId() {
        return this.userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId
     */
    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户email
     *
     * @return
     */
    @Override
    public String getUserEmail() {
        return this.userEmail;
    }

    /**
     * 设置用户email
     *
     * @param userEmail
     */
    @Override
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取用户类型
     *
     * @return
     */
    @Override
    public Integer getUserType() {
        return this.userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType
     */
    @Override
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取用户手机号
     *
     * @return
     */
    @Override
    public String getUserMobile() {
        return this.userMobile;
    }

    /**
     * 设置用户手机号
     *
     * @param userMobile
     */
    @Override
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 获取部门机构名称
     *
     * @return
     */
    @Override
    public String getUnitName() {
        return this.unitName;
    }

    /**
     * 设置部门机构名称
     *
     * @param unitName
     */
    @Override
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取部门机构编码
     *
     * @return
     */
    @Override
    public String getUnitCode() {
        return this.unitCode;
    }

    /**
     * 设置部门机构编码
     *
     * @param unitCode
     */
    @Override
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    /**
     * 获取部门机构ID
     *
     * @return
     */
    @Override
    public Long getUnitId() {
        return this.unitId;
    }

    /**
     * 设置部门机构ID
     *
     * @param unitId
     */
    @Override
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    /**
     * 是否租户管理机构
     *
     * @return
     */
    @Override
    public boolean isTenantAdminUnit() {
        return this.tenantAdminUnit;
    }

    /**
     * 设置是否租户管理机构
     */
    @Override
    public void setTenantAdminUnit(boolean tenantAdminUnit) {
        this.tenantAdminUnit = tenantAdminUnit;
    }

    /**
     * 设置是否租户管理员
     *
     * @param tenantAdmin
     */
    @Override
    public void setTenantAdmin(boolean tenantAdmin) {
        this.tenantAdmin = tenantAdmin;
    }

    /**
     * 是否租户管理员
     *
     * @return
     */
    @Override
    public boolean isTenantAdmin() {
        return this.tenantAdmin;
    }

    /**
     * 是否管理员(平台管理员)
     *
     * @return
     */
    @Override
    public boolean isAdmin() {
        return this.admin;
    }

    /**
     * 设置是否管理员(平台管理员)
     *
     * @param admin
     */
    @Override
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        if (!CollectionUtils.isEmpty(this.getRoles())) {
            this.getRoles().forEach(roleId -> auths.add(new SimpleGrantedAuthority(roleId)));
        }
        return auths;

    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
