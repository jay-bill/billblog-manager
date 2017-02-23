package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Sharecount;

public interface SharecountMapper {
    int deleteByPrimaryKey(Long weiboId);

    int insert(Sharecount record);

    int insertSelective(Sharecount record);

    Sharecount selectByPrimaryKey(Long weiboId);

    int updateByPrimaryKeySelective(Sharecount record);

    int updateByPrimaryKey(Sharecount record);
}