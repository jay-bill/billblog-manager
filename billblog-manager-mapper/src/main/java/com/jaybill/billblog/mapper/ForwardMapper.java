package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Forward;

public interface ForwardMapper {
    int insert(Forward record);

    int insertSelective(Forward record);
}