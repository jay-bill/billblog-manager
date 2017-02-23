package com.jaybill.billblog.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.jaybill.billblog.pojo.Comments;
import com.jaybill.billblog.pojo.Reply;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.CommentService;
import com.jaybill.billblog.service.CommonService;
import com.jaybill.billblog.service.WeiboService;

/**
 * 评论功能 控制器
 * 使用websocket
 * @author jaybill
 *
 */
@Controller
@RequestMapping(value="commentcontroller")
public class CommentController{
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private WeiboService weiboService;
	/**
	 * 显示评论
	 * @param becommentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="showcomment.do")
	public List<Object> showComment(@RequestParam("becommentId") long becommentId,
			@RequestParam("offset") long offset){
		//获取评论
		List<Comments> comList = commentService.getComments(becommentId, offset);
		//根据获取到的评论里面的id，获取User信息
		Iterator<Comments> it = comList.iterator();
		List<User> userList = new ArrayList<User>();
		//回复数
		List<Integer> replySumList = new ArrayList<Integer>();
		while(it.hasNext()){
			Comments comment = it.next();
			//根据id获取user信息
			User user = commonService.getUserBaseInfo(comment.getCommentReviewerid());
			//添加到List中
			userList.add(user);
			//获取当前评论的回复数
			int replySum = commentService.getReplySum(becommentId,comment.getCommentId());
			//添加到列表
			replySumList.add(replySum);
		}
		//将comList和userList添加到list里面返回，list[0]为comList，list[1]为userList。
		List<Object> list = new ArrayList<Object>();
		list.add(comList);
		list.add(userList);
		list.add(replySumList);
		return list;
	}
	
	/**
	 * 发表评论
	 * @param becommentId
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value="submitcomment.do",method=RequestMethod.POST)
	public int[] submitComment(@RequestParam("becommentId") long becommentId,
			@RequestParam("commentContent") String commentContent,
			@RequestParam("beinfoId") long beinfoId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		long commentReviewerId = (long)session.getAttribute("user_id");
		int res  =commentService.addComment(becommentId, commentReviewerId,commentContent
											,beinfoId);
		if(res == 0)
			return null;
		return new int[]{res};
	}
	
	/**
	 * 逻辑删除评论
	 * @param commentId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deletecomment.do",method=RequestMethod.POST)
	public String[] deleteComment(@RequestParam("commentId") long commentId,
			HttpServletRequest request){
		//逻辑删除，将comment_state置为一
		int res = commentService.deleteComment(commentId);
		if(res==0)
			return null;
		return new String[]{"1"};//随便返回一个值
	}
	
	/**
	 * 提交回复
	 * @param replyContent
	 * @param weiboId
	 * @param commentId
	 * @param bereplyId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="submitreply.do",method=RequestMethod.POST)
	public List<Object> submitReply(@RequestParam("replyContent") String replyContent,
			@RequestParam("weiboId") long weiboId,
			@RequestParam("commentId") long commentId,
			@RequestParam("bereplyId") long bereplyId,
			HttpServletRequest request){
		//回复
		Reply reply  = new Reply();
		reply.setCommentId(commentId);
		reply.setWeiboId(weiboId);
		reply.setReplyContent(replyContent);
		reply.setBereplyId(bereplyId);//被回复的人的id
		reply.setReplyUserid((long)request.getSession().getAttribute("user_id"));//发表回复的人
		reply.setReplyTime(new Timestamp(new Date().getTime()));
		//插入数据库
		int res = commentService.insertReply(reply);
		//如果插入失败
		if(res==0)
			return null;
		//获取插入记录的id
		long id = commentService.getReplyId(reply.getReplyUserid());
		reply.setReplyId(id);
		//如果插入成功，则把这条回复放入list中返回前端:list[0]为回复内容，list[1]为被回复的人的信息
		List<Object> list = new ArrayList<Object>();
		User user = commonService.getUserBaseInfo(bereplyId);
		list.add(reply);
		list.add(user);
		return list;
	}
	
	/**
	 * 获取回复
	 * @param weiboId
	 * @param commentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getreply.do",method=RequestMethod.POST)
	public List<Object> getreply(@RequestParam("weiboId") long weiboId,
					@RequestParam("commentId") long commentId){
		//存放回复的内容
		List<Reply> listReply = commentService.getReply(weiboId,commentId);
		//存放用户信息
		List<User> listUser = new ArrayList<User>();
		//存放用户信息
		List<User> listBeUser = new ArrayList<User>();
		//存放微博主人的id
		List<Long> listHost = new ArrayList<Long>();
		if(listReply==null||listReply.size()<=0){
			return null;//没有任何回复
		}
		Iterator<Reply> it = listReply.iterator();
		while(it.hasNext()){
			Reply reply = it.next();
			long alreadyReplyManId = reply.getReplyUserid();//回复者的id
			long beReplayManId = reply.getBereplyId();
			//获取基本信息
			User user = commonService.getUserBaseInfo(alreadyReplyManId);
			User beUser = commonService.getUserBaseInfo(beReplayManId);
			//根据weiboId获取这条微博的用户信息，使之享有可以删除任何回复的权利
			long weiboHostId = weiboService.getOneWeiboById(reply.getWeiboId()).getUserId();
			listUser.add(user);//添加
			listBeUser.add(beUser);
			listHost.add(weiboHostId);
		}
		//构造最终的容器
		List<Object> listObj = new ArrayList<Object>();
		//listObj[0]回复的内容，listObj[1]用户信息，listObj[2]为被回复的人的信息，listObj[3]为微博主任的id
	    listObj.add(listReply);
	    listObj.add(listUser);
	    listObj.add(listBeUser);
	    listObj.add(listHost);
		return listObj;
	}
	
	/**
	 * 删除回复
	 * @param reply
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deletereply.do",method=RequestMethod.POST)
	public String [] deleteReply(@RequestParam("replyId")long reply,
			HttpServletRequest request){
		long userId = (long)request.getSession().getAttribute("user_id");
		int res = commentService.deleteReply(reply,userId);
		if(res==0)
			return null;
		return new String[]{};				
	}
}
