package com.lanrenspace.kakami.service;

import com.lanrenspace.kakami.base.IBaseBeanService;
import com.lanrenspace.kakami.entity.AnonymousResource;
import com.lanrenspace.kakami.mapper.AnonymousResourceMapper;

import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface AnonymousResourceService extends IBaseBeanService<AnonymousResource, AnonymousResourceMapper> {

    /**
     * 批量保存
     *
     * @param anonymousResources
     */
    void batchSave(List<AnonymousResource> anonymousResources);
}
