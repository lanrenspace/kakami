package com.lanrenspace.kakami.entity;

import com.lanrenspace.kakami.base.DataEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description: 数据密匙
 **/
@Data
public class DataCryptoInfo extends DataEntity<DataCryptoInfo> {

    /**
     * 租户编码
     */
    private String tenantCode;

    /**
     * 公匙
     */
    private String publicKey;

    /**
     * 私匙
     */
    private String privateKey;

    /**
     * 类型：0 系统级 1 租户级
     */
    private Boolean type;

    /**
     * 有效期
     */
    private LocalDateTime effectiveTime;
}
