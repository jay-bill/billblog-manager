package com.jaybill.billblog.service;

import java.util.List;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;

/**
 * 关注与被关注的功能
 * @author jaybill
 *
 */
public interface AttentionService {
	/**
	 * 关注
	 * @param noticerId 关注者
	 * @param beNoticedId 被关注者
	 * @return
	 */
	int insertAttention(long noticerId,long beNoticedId); 
	/**
	 * 取消关注
	 * @param noticerId 关注者
	 * @param beNoticedId 被关注者
	 * @return
	 */
	int deleteAttention(long noticerId,long beNoticedId);
	/**
	 * 获取当前用户关注的用户的基本信息
	 * @param userId
	 * @return
	 */
	List<User> getBeNoticedUser(long userId,long offset);
	/**
	 * 获取被关注的用户详细信息
	 * @param userId
	 * @return
	 */
	List<Userinfo> getBeNoticedUserinfo(long userId,long offset);
	/**
	 * 获取粉丝的基本 信息
	 * @param userId
	 * @return
	 */
	List<User> getFansUser(long userId,long offset);
	/**
	 * 获取粉丝的详细信息
	 * @param userId
	 * @return
	 */
	List<Userinfo> getFansUserinfo(long userId,long offset);
	/**
	 * 判断是否已关注
	 * @param noticerId
	 * @param beNoticedId
	 * @return
	 */
	int isAlreadyNoticed(long noticerId, long beNoticedId);
}
