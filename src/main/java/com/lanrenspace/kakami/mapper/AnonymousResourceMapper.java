package com.lanrenspace.kakami.mapper;

import com.lanrenspace.kakami.base.IBaseBeanMapper;
import com.lanrenspace.kakami.entity.AnonymousResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface AnonymousResourceMapper extends IBaseBeanMapper<AnonymousResource> {

    /**
     * 批量新增
     *
     * @param list
     */
    void batchInsert(@Param("list") List<AnonymousResource> list);
}
