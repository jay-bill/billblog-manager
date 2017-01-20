package com.jaybill.billblog.serviceimf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.Weibo;
import com.jaybill.billblog.service.WeiboService;

@Service
public class WeiboServiceImf implements WeiboService {

	@Autowired
	private WeiboMapper weiboMapper;
	/**
	 * 每次最多选出20条
	 */
	@Override
	public List<Weibo> getMineAndMynoticeWeibo(long userId,long offset) {
		List<Weibo> weiboList = weiboMapper.selectMineAndMynoticeWeibo(userId,offset);
		return weiboList;
	}
	/**
	 * 每次最多选出20条
	 */
	@Override
	public List<Weibo> getOneUserWeibo(long userId, long offset) {
		List<Weibo> weiboList = weiboMapper.selectOneUserWeibo(userId,offset);
		return weiboList;
	}
	
	/**
	 * 发微博
	 */
	@Override
	public void broadcastWeibo(Weibo weibo) {
		weiboMapper.insert(weibo);
	}

}
