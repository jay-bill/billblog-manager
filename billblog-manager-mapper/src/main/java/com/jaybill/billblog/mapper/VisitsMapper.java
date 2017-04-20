package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Visits;

public interface VisitsMapper {
    int insert(Visits record);

    Visits selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(long userId);
}