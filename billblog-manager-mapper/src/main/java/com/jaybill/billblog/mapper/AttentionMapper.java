package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Attention;
import com.jaybill.billblog.pojo.AttentionKey;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;

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

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
	List<User> selectFansListUser(long userId,long offset);

	/**
	 * 获取粉丝列表
	 * @param userId
	 * @return
	 */
	List<Userinfo> selectFansListUserinfo(long userId,long offset);

	/**
	 * 获取关注列表
	 * @param userId
	 * @param offset
	 * @return
	 */
	List<User> selectNoticeListUser(long userId, long offset);
}