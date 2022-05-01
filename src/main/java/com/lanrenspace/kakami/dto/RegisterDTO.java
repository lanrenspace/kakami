package com.lanrenspace.kakami.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author lanrenspace@163.com
 * @Description: 注册表单信息
 **/
@Data
public class RegisterDTO implements Serializable {

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 登录密码
     */
    private String pwd;

    /**
     * 邮箱验证码
     */
    private String emailCode;
}
