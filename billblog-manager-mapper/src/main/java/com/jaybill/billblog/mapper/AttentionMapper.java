package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Attention;
import com.jaybill.billblog.pojo.AttentionKey;

public interface AttentionMapper {
    int deleteByPrimaryKey(AttentionKey key);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(AttentionKey key);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
    
    /**
     * 计算attention表中的粉丝数目
     */
    int selectFansSum(long attentionBenoticedid);
    
    /**
     * 计算attention表中关注的人的数目
     */
    int selectBenoticedSum(long attentionNoticerid);
}