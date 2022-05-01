package com.lanrenspace.kakami.service.imp;

import com.lanrenspace.kakami.base.impl.BaseBeanServiceImpl;
import com.lanrenspace.kakami.entity.AnonymousResource;
import com.lanrenspace.kakami.mapper.AnonymousResourceMapper;
import com.lanrenspace.kakami.service.AnonymousResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@Service
public class AnonymousResourceServiceImpl extends BaseBeanServiceImpl<AnonymousResource, AnonymousResourceMapper> implements AnonymousResourceService {
    /**
     * 批量保存
     *
     * @param anonymousResources
     */
    @Override
    public void batchSave(List<AnonymousResource> anonymousResources) {
        if (CollectionUtils.isEmpty(anonymousResources)) {
            return;
        }
        getMapper().batchInsert(anonymousResources);
    }
}
