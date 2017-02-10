package com.jaybill.billblog.service;

import java.util.List;

import com.jaybill.billblog.pojo.Comments;
import com.jaybill.billblog.pojo.User;

/**
 * 评论服务
 * @author jaybill
 *
 */
public interface CommentService {
	
	/**
	 * 查看评论
	 * @param becommentId
	 * @return
	 */
	List<Comments> getComments(long becommentId,long offset);
	
	/**
	 * 获取评论者信息
	 * @param commentReviewerId
	 * @return
	 */
	User getCommentsUser(long commentReviewerId);
	
	/**
	 * 增加评论
	 * @param becommentId
	 * @param commentReviewerId
	 * @param commentContent 
	 * @return
	 */
	int addComment(long becommentId,long commentReviewerId, String commentContent,
			long beinfoId);
	
	/**
	 * 删除评论
	 * @param commentId
	 * @return
	 */
	int deleteComment(long commentId);

	/**
	 * 获取评论总数
	 * @param weiboId
	 * @return
	 */
	int getCommentSum(long weiboId);

	/**
	 * 删除评论
	 * @param commentId
	 * @return
	 */
	int deleteComment(long userId, long commentId);
}
