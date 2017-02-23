package com.jaybill.billblog.serviceimf;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.CommentsMapper;
import com.jaybill.billblog.mapper.InfoMapper;
import com.jaybill.billblog.mapper.ReplyMapper;
import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.Comments;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.Reply;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.CommentService;
import com.jaybill.billblog.time.TimeUtils;

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
	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private WeiboMapper weiboMapper;
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

	/**
	 * 提交回复
	 */
	@Override
	public int insertReply(Reply reply) {	
		/**
		 * 当前用户直接回复的人，如果不是自己，则通知他；
		 * 如果当前用户直接回复的人是微博的原作者，就只通知一次,不通知自己；
		 * 如果微博原作者回复别人，不再通知自己。
		 */
		//通知被回复者
		if(reply.getReplyUserid()!=reply.getBereplyId()){			
			Info info = new Info();
			info.setBeinfoId(reply.getBereplyId());//收到通知的人
			info.setInfoId(reply.getReplyUserid());//发出通知的人
			info.setInfoContent(reply.getWeiboId()+"@_@"+"回复了你：<br>"+reply.getReplyContent());
			info.setInfoState((byte)0);
			info.setInfoTime(new Timestamp(new Date().getTime()));
			//插入
			infoMapper.insert(info);			
		}	
		
		//通知微博原作者
		//原微博作者id
		long oriId = weiboMapper.selectByPrimaryKey(reply.getWeiboId()).getUserId();
		if(oriId!=reply.getBereplyId()&&oriId!=reply.getReplyUserid()){			
			Info info = new Info();
			info.setBeinfoId(oriId);
			info.setInfoId(reply.getReplyUserid());//发出通知的人
			info.setInfoContent(reply.getWeiboId()+"@_@"+"回复了你：<br>"+reply.getReplyContent());
			info.setInfoState((byte)0);
			info.setInfoTime(new Timestamp(new Date().getTime()));
			infoMapper.insert(info);
		}
		int res = replyMapper.insert(reply);//插入数据库	
		return res;		
	}

	/**
	 * 获取回复
	 */
	@Override
	public List<Reply> getReply(long weiboId, long commentId) {
		List<Reply> list = replyMapper.selectById(weiboId,commentId);
		return list;
	}

	/**
	 * 获取id
	 */
	@Override
	public long getReplyId(Long replyUserid) {
		Reply re  = replyMapper.selectReplyId(replyUserid);
		long id = re.getReplyId();
		return id;
	}
	
	/**
	 * 删除回复
	 * @param replyId
	 * @return
	 */
	public int deleteReply(Long replyId){
		return 0;
	}

	/**
	 * 删除回复
	 * @return
	 */
	@Override
	public int deleteReply(long replyId, long userId) {
		 //先获取Reply实例，获取Reply里面主动回复的人，判断和当前用户是不是同一个人
		 Reply re = replyMapper.selectByPrimaryKey(replyId);
		 //如果回复所在的微博是属于当前用户的，也可以删除
		 long weiboBelongId = weiboMapper.selectByPrimaryKey(re.getWeiboId()).getUserId();
		 if(re.getReplyUserid()==userId||weiboBelongId==userId){
			 //删除
			 return replyMapper.deleteByPrimaryKey(replyId);
		 }
	     return 0;
	}
	
	/**
	 * 获取回复总数
	 * @param weiboId
	 * @param commentId
	 * @return
	 */
	public int getReplySum(long weiboId,long commentId){
		return replyMapper.selectReplySum(weiboId,commentId);
	}
}
