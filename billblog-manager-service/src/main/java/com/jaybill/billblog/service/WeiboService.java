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

	void broadcastWeibo(Weibo weibo);
}
