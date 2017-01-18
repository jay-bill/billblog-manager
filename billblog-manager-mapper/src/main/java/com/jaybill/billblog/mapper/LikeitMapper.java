package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.LikeitKey;

public interface LikeitMapper {
    int deleteByPrimaryKey(LikeitKey key);

    int insert(LikeitKey record);

    int insertSelective(LikeitKey record);
}