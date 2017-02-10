package com.jaybill.billblog.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.CommonService;
import com.jaybill.billblog.service.LikeService;

/**
 * 点赞功能控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping("likecontroller")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	@Autowired
	private CommonService commonService;

	/**
	 * 点赞微博
	 * @param belikeId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="makelikeweibo.do",method=RequestMethod.POST)
	public String[] makeLikeWeibo(@RequestParam("belikeId") long belikeId,
			@RequestParam("beinfoId") long beinfoId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		long likePeopleId = (long)session.getAttribute("user_id");
		//点赞
		int res = likeService.insertLikeWeibo(likePeopleId, belikeId,beinfoId);
		if(res==0)//点赞失败
			return null;
		return new String[]{"1"};
	}
	
	/**
	 * 取消点赞
	 * @param belikeId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="avoidlikeweibo.do",method=RequestMethod.GET)
	public String[] avoidLikeWeibo(@RequestParam("belikeId") long belikeId,
			@RequestParam("beinfoId") long beinfoId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		long likePeopleId = (long)session.getAttribute("user_id");
		//取消点赞
		int res = likeService.deleteLikeWeibo(likePeopleId, belikeId,beinfoId);
		if(res==0)
			return null;
		return new String[]{"1"};
	}
	
	/**
	 * 判断是否点赞
	 * @param belikeId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="isalreadylike.do")
	public String[] isAlreadyLike(@RequestParam("belikeId") long belikeId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		long likePeopleId = (long)session.getAttribute("user_id");
		//判断是否已经点赞
		int res = likeService.selectIsAlreadyLike(likePeopleId,belikeId);
		if(res==0)//没有点赞，回到ajax的error中
			return null;
		return new String[]{"1"};//已经点赞，回到ajax的success中
	}
	
	/**
	 * 计算微博的点赞总数
	 * @param belikeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getlikesum.do")
	public String[] getLikeSum(@RequestParam("belikeId") long belikeId){
		//获取点赞总数
		int sum = likeService.getLikeSum(belikeId);
		if(sum==0)
			return null;//如果没被点赞，返回0
		return new String[]{sum+""};//返回点赞总数
	}
	/**
	 * 查看所有点赞的人，每页列出10个
	 * @param belikeId
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="showlikepeople.do",method=RequestMethod.GET)
	public String showLikeItPeople(@RequestParam("belikeId") long belikeId,
			@RequestParam("offset") long offset,
			HttpServletRequest request,Map<String,Object> map){
		//根据传入的被点赞的内容，获取已点赞的用户信息
		List<User> userList = likeService.selectPeopleLiked(belikeId,offset);
		//获取点赞的时间，倒序
		List<Timestamp> timeList = likeService.selectLikeTime(belikeId,offset);
		//获取点赞总数
		int sum = likeService.getLikeSum(belikeId);
		//共享到页面
		map.put("other_user_base_info_list", userList);
		map.put("like_time_list", timeList);
		map.put("like_sum", sum);
		return "likepeople-list";
	}
}
