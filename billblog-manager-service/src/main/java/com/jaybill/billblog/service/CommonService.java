package com.jaybill.billblog.service;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;

public interface CommonService {
	/**
	 * 获取用户的账号信息，即USER表
	 * @param userAccount
	 * @return
	 */
	User getUserBaseInfo(String userAccount);
	User getUserBaseInfo(long userId);
	/**
	 * 获取用户的详细信息
	 * @param userAccount
	 * @return
	 */
	Userinfo getUserInfo(long userId);
	
	/**
	 * 计算粉丝的数目
	 */
	int getFansSum(long userId);
	
	/**
	 * 计算关注的人的数目
	 */
	int getBeNoticeSum(long userId);
	
	/**
	 * 计算微博的总数
	 */
	int getWeiboSum(long userId);
	
	/**
	 * 更新用户的详细信息
	 */
	void updateUserInfo(User user,Userinfo userInfo);
}
