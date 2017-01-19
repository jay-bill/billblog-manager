package com.jaybill.billblog.serviceimf;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.UserMapper;
import com.jaybill.billblog.mapper.UserinfoMapper;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.RegistService;
/**
 * RegistService接口实现类，完成注册的业务逻辑
 * @author jaybill
 *
 */
@Service
public class RegistServiceImf implements RegistService {
	
	private final static String HEAD_IMAGE = "/billblog-manager-controller/resource/image/headimage.jpg";
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserinfoMapper infoMapper;
	/**
	 * 将user组装插入数据库
	 */
	public long addUser(String userAccount, String userPassword) {
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserPassword(userPassword);
		user.setUserDatetime(new Timestamp(new Date().getTime()));
		user.setUserIdentity((byte)0);//0表示普通用户
		user.setUserState((byte)0);//0表示没被封号
		user.setUserHeadimage(HEAD_IMAGE);//默认头像
		user.setUserNickname(userAccount);//昵称默认为账号
		user.setUserLevel((byte)0);//等级默认为0
		userMapper.insert(user); //插入数据库
		return getUserKey(userAccount);//返回id
	}
	
	/**
	 * 获取用户的id
	 * @param userAccount
	 * @return
	 */
	public long getUserKey(String userAccount){
		User user = userMapper.selectByUserAccount(userAccount);
		return user.getUserId();//返回用户的id
	}
	/**
	 * 判断账号是否已经被注册
	 * @param userAccount
	 * @return
	 */
	public boolean isAccountExisted(String userAccount){
		User isExisted = userMapper.selectByUserAccount(userAccount);
		if(isExisted!=null)
			return true;
		return false;
	}

	/**
	 * 初始化用户信息,将用户的id插入信息表
	 */
	@Override
	public void addUserinfo(Userinfo userinfo) {
		infoMapper.insert(userinfo);
	}
}
