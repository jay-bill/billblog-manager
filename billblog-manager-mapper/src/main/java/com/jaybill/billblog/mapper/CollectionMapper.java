package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Collection;

public interface CollectionMapper {
    int deleteByPrimaryKey(Long collectionId);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Long collectionId);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}