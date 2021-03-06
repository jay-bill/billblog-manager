package com.jaybill.billblog.service;

import java.util.List;

import com.jaybill.billblog.pojo.Weibo;

/**
 * 微博接口
 * @author jaybill
 *
 */
public interface WeiboService {
	/**
	 * 获取我关注的和我的微博20条
	 * @param userId
	 * @return
	 */
	List<Weibo> getMineAndMynoticeWeibo(long userId,long offset);

	/**
	 * 异步获取某个用户的微博
	 * @param userId
	 * @param offset
	 * @return
	 */
	List<Weibo> getOneUserWeibo(long userId, long offset);

	void insertBroadcastWeibo(Weibo weibo);

	/**
	 * 逻辑删除微博
	 * @param weiboId
	 * @return
	 */
	int deleteWeibo(long weiboId);

	/**
	 * 根据微博id获取微博内容
	 * @param oriWeiboId
	 * @return
	 */
	Weibo getOneWeiboById(long oriWeiboId);
	
	/**
	 * 插入访问者，新增访问量
	 * @param visitorId
	 * @param userId
	 */
	void insertVisitor(String visitoIp,long userId);
	
	/**
	 * 插入访问者，新增访问量
	 * @param visitorId
	 * @param userId
	 * @param visitoIp
	 */
	void insertVisitor(long visitorId,long userId,String visitoIp);
	
	/**
	 * 获取页面访问量
	 * @param userId
	 * @return
	 */
	long getVisits(long userId);
}
