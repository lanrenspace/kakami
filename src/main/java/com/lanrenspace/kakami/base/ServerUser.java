package com.lanrenspace.kakami.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface ServerUser extends Serializable {

    /**
     * 获取用户名称
     *
     * @return
     */
    String getUserName();

    /**
     * 设置用户名称
     *
     * @param userName
     */
    void setUserName(String userName);

    /**
     * 获取用户账号
     *
     * @return
     */
    String getUserAccount();

    /**
     * 设置用户账号
     *
     * @param userAccount
     */
    void setUserAccount(String userAccount);

    /**
     * 获取登录IP
     *
     * @return
     */
    String getIp();

    /**
     * 设置登录IP
     *
     * @param ip
     */
    void setIp(String ip);

    /**
     * 是否启用
     *
     * @return
     */
    boolean isEnabled();

    /**
     * 是否启用
     *
     * @param enabled
     */
    void setEnabled(boolean enabled);


    /**
     * 获取角色列表
     *
     * @return
     */

    List<String> getRoles();


    /**
     * 设置角色信息
     *
     * @param roles
     */
    void setRoles(List<String> roles);

    /**
     * 账号是否未过期
     *
     * @return
     */
    boolean isAccountNonExpired();

    /**
     * 是否未过期
     *
     * @param accountNonExpired
     */
    void setAccountNonExpired(boolean accountNonExpired);

    /**
     * 账号是否未锁定
     *
     * @return
     */
    boolean isAccountNonLocked();

    /**
     * 是否未锁定
     *
     * @param accountNonLocked
     */
    void setAccountNonLocked(boolean accountNonLocked);

    /**
     * 证书是否未过期
     *
     * @return
     */
    boolean isCredentialsNonExpired();

    /**
     * 证书是否未过期
     *
     * @param credentialsNonExpired
     */
    void setCredentialsNonExpired(boolean credentialsNonExpired);


    /**
     * 获取token
     *
     * @return
     */
    String getToken();

    /**
     * 设置token
     *
     * @param token
     */
    void setToken(String token);

    /**
     * 获取租户编码
     *
     * @return
     */
    String getTenantCode();

    /**
     * 设置租户编码
     *
     * @param tenantCode
     */
    void setTenantCode(String tenantCode);


    /**
     * 获取用户ID
     *
     * @return
     */
    Long getUserId();

    /**
     * 设置用户ID
     *
     * @param userId
     */
    void setUserId(Long userId);

    /**
     * 获取用户email
     *
     * @return
     */
    String getUserEmail();

    /**
     * 设置用户email
     *
     * @param userEmail
     */
    void setUserEmail(String userEmail);

    /**
     * 获取用户类型
     *
     * @return
     */
    Integer getUserType();

    /**
     * 设置用户类型
     *
     * @param userType
     */
    void setUserType(Integer userType);

    /**
     * 获取用户手机号
     *
     * @return
     */
    String getUserMobile();

    /**
     * 设置用户手机号
     *
     * @param userMobile
     */
    void setUserMobile(String userMobile);

    /**
     * 获取部门机构名称
     *
     * @return
     */
    String getUnitName();

    /**
     * 设置部门机构名称
     *
     * @param unitName
     */
    void setUnitName(String unitName);

    /**
     * 获取部门机构编码
     *
     * @return
     */
    String getUnitCode();


    /**
     * 设置部门机构编码
     *
     * @param unitCode
     */
    void setUnitCode(String unitCode);

    /**
     * 获取部门机构ID
     *
     * @return
     */
    Long getUnitId();

    /**
     * 设置部门机构ID
     *
     * @param unitId
     */
    void setUnitId(Long unitId);

    /**
     * 是否租户管理机构
     *
     * @return
     */
    boolean isTenantAdminUnit();

    /**
     * 设置是否租户管理机构
     */
    void setTenantAdminUnit(boolean tenantAdminUnit);

    /**
     * 设置是否租户管理员
     *
     * @param tenantAdmin
     */
    void setTenantAdmin(boolean tenantAdmin);

    /**
     * 是否租户管理员
     *
     * @return
     */
    boolean isTenantAdmin();

    /**
     * 是否管理员(平台管理员)
     *
     * @return
     */
    boolean isAdmin();


    /**
     * 设置是否管理员(平台管理员)
     *
     * @param admin
     */
    void setAdmin(boolean admin);
}
