package com.lanrenspace.kakami.entity;

import com.lanrenspace.kakami.base.DataEntity;
import lombok.Data;

/**
 * @Author lanrenspace@163.com
 * @Description: 匿名资源信息
 **/
@Data
public class AnonymousResource extends DataEntity<AnonymousResource> {

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 资源类型 1: api 2: 路由
     */
    private Integer type;

    /**
     * 接口地址
     */
    private String url;

    /**
     * http method
     */
    private String httpMethod;

    /**
     * 描述
     */
    private String description;
}
