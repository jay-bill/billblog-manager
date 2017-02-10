package com.jaybill.billblog.service;

import java.sql.Timestamp;
import java.util.List;

import com.jaybill.billblog.pojo.User;

/**
 * 点赞服务
 * @author jaybill
 *
 */
public interface LikeService {
	/**
	 * 点赞
	 * @param likePeopleId
	 * @param belikeId
	 * @return
	 */
	int insertLikeWeibo(long likePeopleId,long belikeId,long beinfoId);
	
	/**
	 * 取消点赞
	 * @param likePeopleId
	 * @param belikeId
	 * @return
	 */
	int deleteLikeWeibo(long likePeopleId,long belikeId,long beinfoId);

	/**
	 * 判断是否点赞了
	 * @param likePeopleId
	 * @param belikeId
	 * @return
	 */
	int selectIsAlreadyLike(long likePeopleId, long belikeId);

	/**
	 * 计算点赞总数
	 * @param belikeId
	 * @return
	 */
	int getLikeSum(long belikeId);

	/**
	 * 显示点赞的人
	 * @param belikeId
	 * @return
	 */
	List<User> selectPeopleLiked(long belikeId,long offset);

	/**
	 * 获取点赞的时间
	 * @param belikeId
	 * @param offset
	 * @return
	 */
	List<Timestamp> selectLikeTime(long belikeId, long offset);
}
