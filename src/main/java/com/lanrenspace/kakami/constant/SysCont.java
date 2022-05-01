package com.lanrenspace.kakami.constant;

import java.nio.charset.StandardCharsets;

/**
 * @Author lanrenspace@163.com
 * @Description: 系统常量
 **/
public interface SysCont {

    /**
     * token类型头
     */
    String TOKEN_TYPE = "KaKaMi_Bearer ";

    /**
     * JWT 密匙
     */
    byte[] JWT_KEY = "HE.LANRENSPACE.KAKAMI_KEY".getBytes(StandardCharsets.UTF_8);

    /**
     * 令牌存储key格式
     */
    String JWT_STORE_KEY = "KAKAMI:TOKEN:STORE:%s";

    /**
     * 系统租户编码
     */
    String SYS_TENANT_CODE = "10001";

    /**
     * 规则填充类型
     */
    String FILL_RULE_CODE = "FILL:RULE:CODE";
}
