package com.jaybill.billblog.serviceimf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.UserMapper;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.LoginService;

@Service
public class LoginServiceImf implements LoginService {

	@Autowired
	private UserMapper userMapper;
	/**
	 * 根据账号密码判断用户能否登录
	 * @param user
	 * @return
	 */
	public User login(User user) {
		//从数据库查找
		User selectedUser = userMapper.selectByAccountAndPword(user);
		//如果没找到返回false，表明可以注册
		return selectedUser;
	}

}
