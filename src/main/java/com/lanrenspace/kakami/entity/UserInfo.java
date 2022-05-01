package com.lanrenspace.kakami.entity;

import com.lanrenspace.kakami.base.DataEntity;
import lombok.Data;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Data
public class UserInfo extends DataEntity<UserInfo> {

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码盐值
     */
    private String salt;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户电话
     */
    private String userMobile;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户头像
     */
    private String userImage;

    /**
     * 用户类型 0 普通用户 1 后台用户 2前台用户
     */
    private Integer userType;

    /**
     * 是否有效
     */
    private Boolean validFlag;

    /**
     * 租户编码
     */
    private String tenantCode;
}
