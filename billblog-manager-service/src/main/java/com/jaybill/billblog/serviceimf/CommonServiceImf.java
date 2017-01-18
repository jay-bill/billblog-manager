package com.jaybill.billblog.serviceimf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.AttentionMapper;
import com.jaybill.billblog.mapper.UserMapper;
import com.jaybill.billblog.mapper.UserinfoMapper;
import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.CommonService;

@Service
public class CommonServiceImf implements CommonService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserinfoMapper infoMapper;
	@Autowired
	private AttentionMapper attentionMapper;
	@Autowired
	private WeiboMapper weiboMapper;
	
	/**
	 *选出用户的账户基本信息
	 */
	@Override
	public User getUserBaseInfo(String userAccount) {
		User userBeSelected = userMapper.selectByUserAccount(userAccount);
		return userBeSelected;
	}

	/**
	 *选出用户的账户基本信息
	 *方法的重载
	 */
	@Override
	public User getUserBaseInfo(long userId) {
		User userBeSelected = userMapper.selectByPrimaryKey(userId);
		return userBeSelected;
	}
	
	/**
	 * 选出用户的详细信息
	 */
	@Override
	public Userinfo getUserInfo(long userId) {
		Userinfo userInfo = infoMapper.selectByPrimaryKey(userId);
		return userInfo;
	}

	/**
	 * 计算粉丝的数目.传入用户的id，查看他的粉丝数
	 */
	@Override
	public int getFansSum(long userId) {
		int sum = attentionMapper.selectFansSum(userId);
		return sum;
	}

	/**
	 * 计算关注的人的数目
	 */
	@Override
	public int getBeNoticeSum(long userId) {
		int sum = attentionMapper.selectBenoticedSum(userId);
		return sum;
	}

	/**
	 * 计算微博的总数
	 */
	@Override
	public int getWeiboSum(long userId) {
		return 0;
	}


}
