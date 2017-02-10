package com.jaybill.billblog.serviceimf;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.CommentsMapper;
import com.jaybill.billblog.mapper.InfoMapper;
import com.jaybill.billblog.pojo.Comments;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.CommentService;

/**
 * 评论
 * @author jaybill
 *
 */
@Service
public class CommentServiceImf implements CommentService{

	@Autowired
	private CommentsMapper commentMapper;
	@Autowired
	private InfoMapper infoMapper;
	/**
	 * 获取评论
	 */
	@Override
	public List<Comments> getComments(long becommentId,long offset) {
		List<Comments> comList = commentMapper.selectCommentByBecommentId(becommentId,offset);
		return comList;
	}

	@Override
	public User getCommentsUser(long commentReviewerId) {
		return null;
	}

	/**
	 * 发表评论
	 */
	@Override
	public int addComment(long becommentId, long commentReviewerId,String content,
			long beinfoId) {
		//评论
		Comments record = new Comments();
		record.setBecommentId(becommentId);
		record.setComentState((byte)0);
		record.setCommentContent(content);
		record.setCommentDatetime(new Timestamp(new Date().getTime()));
		record.setCommentReviewerid(commentReviewerId);
		int res = commentMapper.insert(record);
		//通知：自己通知自己不插入数据库
		if(beinfoId!=commentReviewerId){
			Info info = new Info();
			info.setBeinfoId(beinfoId);
			info.setInfoId(commentReviewerId);
			info.setInfoState((byte)0);
			info.setInfoTime(new Timestamp(new Date().getTime()));
			//通知的内容：被通知内容发id @_@ 自己添加的内容
			info.setInfoContent(becommentId+"@_@"+content);
			infoMapper.insert(info);
		}
		return res;
	}

	@Override
	public int deleteComment(long commentId) {
		int res = commentMapper.deleteByCmtId(commentId);
		return res;
	}
	
	/**
	 * 获取评论总数
	 */
	@Override
	public int getCommentSum(long weiboId) {
		int sum = commentMapper.selectCommentSum(weiboId);
		return sum;
	}

	/**
	 * 删除评论
	 */
	@Override
	public int deleteComment(long userId, long commentId) {
		int res = commentMapper.deleteByUserIdCommentId(userId,commentId);
		return res;
	}

}
