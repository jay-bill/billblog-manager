package com.jaybill.billblog.service;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;

/**
 * 查询服务
 * @author jaybill
 *
 */
public interface SearchService {
	/**
	 * 根据用户的昵称，返回基本信息
	 * @param userNickname
	 * @return
	 */
	User selectUserByNickname(String userNickname);
	/**
	 * 根据用户的id，返回详细信息
	 * @param userNickname
	 * @return
	 */
	Userinfo selectUserinfoByNickname(long userId);
}
