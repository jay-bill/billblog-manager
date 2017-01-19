package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.Weibo;

public interface WeiboMapper {
    int deleteByPrimaryKey(Long weiboId);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    Weibo selectByPrimaryKey(Long weiboId);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKeyWithBLOBs(Weibo record);

    int updateByPrimaryKey(Weibo record);
    
    /**
     * 计算微博总数
     */
    int selectWeiboSum(long userId);
}