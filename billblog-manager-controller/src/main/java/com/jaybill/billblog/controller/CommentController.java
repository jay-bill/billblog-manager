package com.jaybill.billblog.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.CommentService;
import com.jaybill.billblog.service.CommonService;

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
		while(it.hasNext()){
			Comments comment = it.next();
			//根据id获取user信息
			User user = commonService.getUserBaseInfo(comment.getCommentReviewerid());
			//添加到List中
			userList.add(user);
		}
		//将comList和userList添加到list里面返回，list[0]为comList，list[1]为userList。
		List<Object> list = new ArrayList<Object>();
		list.add(comList);
		list.add(userList);
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
}
