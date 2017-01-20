package com.jaybill.billblog.mapper;

import java.util.List;

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

    /**
     * 20条我的和我关注的微博
     * @param userId
     * @return
     */
	List<Weibo> selectMineAndMynoticeWeibo(long userId,long offset);

	/**
	 * 选出某用户的最多20条微博
	 * @param userId
	 * @param offset
	 * @return
	 */
	List<Weibo> selectOneUserWeibo(long userId, long offset);
}