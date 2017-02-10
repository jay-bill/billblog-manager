package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Weibo;

public interface WeiboMapper {
    int deleteByPrimaryKey(Long weiboId);

    int insert(Weibo record);

    int insertSelective(Weibo record);

    Weibo selectByPrimaryKey(Long weiboId);

    int updateByPrimaryKeySelective(Weibo record);

    int updateByPrimaryKeyWithBLOBs(Weibo record);

    int updateByPrimaryKey(Weibo record);
    
    /**
     * 计算微博总数
     */
    int selectWeiboSum(long userId);

    /**
     * 20条我的和我关注的微博
     * @param userId
     * @return
     */
	List<Weibo> selectMineAndMynoticeWeibo(long userId,long offset);

	/**
	 * 选出某用户的最多20条微博
	 * @param userId
	 * @param offset
	 * @return
	 */
	List<Weibo> selectOneUserWeibo(long userId, long offset);
	
	/**
	 * 删除微博
	 * @param weiboId
	 * @param newState 0表示正常状态，1表示删除状态，2表示转发状态，3表示收藏状态
	 * @return
	 */
	int deleteWeibo(long weiboId,byte delState);

	/**
	 * 更新昵称
	 * @param userNickname
	 */
	void updateNicknameCauseBySaveUpateInfo(Long userId, String userNickname);

	/**
	 * 获取所有包含图片的微博
	 * @return
	 */
	List<Weibo> selectContainImages();
}