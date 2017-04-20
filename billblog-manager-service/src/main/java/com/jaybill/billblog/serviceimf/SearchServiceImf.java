package com.jaybill.billblog.serviceimf;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.UserMapper;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.SearchService;

@Service
public class SearchServiceImf implements SearchService {

	@Autowired
	private UserMapper userMapper;
	/**
	 * 根据用户的昵称，返回基本信息
	 * @param userNickname
	 * @return
	 */
	@Override
	public User selectUserByNickname(String userNickname) {
		User user = userMapper.selectByNickname(userNickname);
		return user;
	}

	/**
	 * 根据用户的id，返回详细信息
	 * @param userNickname
	 * @return
	 */
	@Override
	public Userinfo selectUserinfoByNickname(long userId) {
		return null;
	}

}
