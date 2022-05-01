package com.lanrenspace.kakami.entity;

import com.lanrenspace.kakami.base.DataEntity;
import lombok.Data;

/**
 * @Author lanrenspace@163.com
 * @Description: 字典类型
 **/
@Data
public class DictionaryType extends DataEntity<DictionaryType> {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否可维护
     */
    private Boolean updatable;

    /**
     * 租户编码
     */
    private String tenantCode;

    /**
     * 数据字典级别 system,org,suborg
     */
    private String itemScope;
}
