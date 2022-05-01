package com.lanrenspace.kakami.entity;

import com.lanrenspace.kakami.base.DataEntity;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * @Author lanrenspace@163.com
 * @Description: 租户信息
 **/
@Table("tenant_info")
@Data
public class TenantInfo extends DataEntity<TenantInfo> {

    /**
     * 管理员编码
     */
    private String adminCode;

    /**
     * 管理员账号
     */
    private String adminAccount;

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 是否有效：1 有效 0 无效
     */
    private Boolean validFlag;

    /**
     * 租户编号
     */
    private String tenantCode;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * logo地址
     */
    private String logoUrl;

    /**
     * 简介
     */
    private String description;

    /**
     * 审核日期
     */
    private LocalDateTime auditTime;

    /**
     * 备注信息
     */
    private String remark;
}
