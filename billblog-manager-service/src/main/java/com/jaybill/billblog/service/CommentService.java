package com.jaybill.billblog.service;

import java.sql.Timestamp;
import java.util.List;

import com.jaybill.billblog.pojo.Comments;
import com.jaybill.billblog.pojo.Reply;
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

	/**
	 * 提交回复
	 * @param reply
	 * @return
	 */
	int insertReply(Reply reply);

	/**
	 * 获取某条微博评论的回复
	 * @param weiboId
	 * @param commentId
	 * @return
	 */
	List<Reply> getReply(long weiboId, long commentId);

	/**
	 * 根据当前用户和事件获取回复的id
	 * @param replyUserid
	 * @param replyTime
	 * @return
	 */
	long getReplyId(Long replyUserid);
	
	/**
	 * 删除回复
	 * @param replyId
	 * @return
	 */
	public int deleteReply(Long replyId);
	/**
	 * 删除回复
	 * @param reply
	 * @param userId
	 * @return
	 */
	int deleteReply(long reply, long userId);
	
	/**
	 * 获取回复总数
	 * @param weiboId
	 * @param commentId
	 * @return
	 */
	public int getReplySum(long weiboId,long commentId);
}
