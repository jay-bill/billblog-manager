package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);

    /**
     * 获取评论
     * @param becommentId
     * @param offset 
     * @return
     */
	List<Comments> selectCommentByBecommentId(long becommentId, long offset);

	/**
	 * 获取每条微博的评论总数
	 * @param weiboId
	 * @return
	 */
	int selectCommentSum(long weiboId);

	/**
	 * 逻辑删除评论
	 * @param userId
	 * @param commentId
	 * @return
	 */
	int deleteByUserIdCommentId(long userId, long commentId);

	/**
	 * 逻辑删除
	 * @param commentId
	 * @return
	 */
	int deleteByCmtId(long commentId);
}