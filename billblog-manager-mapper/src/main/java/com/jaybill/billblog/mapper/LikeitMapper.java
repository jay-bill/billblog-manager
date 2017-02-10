package com.jaybill.billblog.mapper;

import java.sql.Timestamp;
import java.util.List;

import com.jaybill.billblog.pojo.LikeitKey;
import com.jaybill.billblog.pojo.User;

public interface LikeitMapper {
    int deleteByPrimaryKey(LikeitKey key);

    int insert(LikeitKey record);

    int insertSelective(LikeitKey record);

    /**
     * 取消点赞
     * @param likePeopleId
     * @param belikeId
     * @return
     */
	int deleteTogetherId(long likePeopleId, long belikeId);

	/**
	 * 选出点赞的记录
	 * @param likePeopleId
	 * @param belikeId
	 * @return
	 */
	LikeitKey selectLikeWeibo(long likePeopleId, long belikeId);

	/**
	 * 计算点赞总数
	 * @param belikeId
	 * @return
	 */
	int selectLikeSum(long belikeId);

	/**
	 * 显示点赞的人的信息
	 * @param belikeId 
	 * @param offset 
	 * @return
	 */
	List<User> selectUserLiked(long belikeId, long offset);

	/**
	 * 获取点赞时间
	 * @param belikeId
	 * @param offset
	 * @return
	 */
	List<Timestamp> selectLikeTime(long belikeId, long offset);

	/**
	 * 获取条微博的点赞总数
	 * @param weiboId
	 * @return
	 */
	List<Integer> getMineAndnoticeLike(Long weiboId);
}