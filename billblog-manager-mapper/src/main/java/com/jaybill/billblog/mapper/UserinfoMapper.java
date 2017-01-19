package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

}