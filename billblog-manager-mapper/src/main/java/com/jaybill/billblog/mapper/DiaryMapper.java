package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Diary;

public interface DiaryMapper {
    int deleteByPrimaryKey(Long diaryId);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(Long diaryId);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKeyWithBLOBs(Diary record);

    int updateByPrimaryKey(Diary record);
}