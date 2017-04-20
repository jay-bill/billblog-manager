package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Visitor;

public interface VisitorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Long id);

    List<Visitor> selectByUserId(long id);
    
    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
}