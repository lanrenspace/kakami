package com.lanrenspace.kakami.entity;

import com.lanrenspace.kakami.base.DataEntity;
import lombok.Data;

/**
 * @Author lanrenspace@163.com
 * @Description: 字典项
 **/
@Data
public class DictionaryItem extends DataEntity<DictionaryItem> {

    /**
     * 字典类型编码
     */
    private String dictionaryCode;

    /**
     * 字典编码
     */
    private String itemCode;

    /**
     * 字典名称
     */
    private String itemName;

    /**
     * 字典值
     */
    private String itemValue;

    /**
     * 排序编号
     */
    private Integer orderNum;

    /**
     * 是否可维护
     */
    private Boolean updatable;

    /**
     * 租户编码
     */
    private String tenantCode;
}
