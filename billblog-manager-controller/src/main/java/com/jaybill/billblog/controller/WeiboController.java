package com.jaybill.billblog.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jaybill.billblog.exception.CantFindThisIdException;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.pojo.Weibo;
import com.jaybill.billblog.service.CommonService;
import com.jaybill.billblog.service.WeiboService;

/**
 * 微博 控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping("weibocontroller")
public class WeiboController {
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private WeiboService weiboServcie;
	/**
	 * 每次调用controller里面的@RequestMapping标注的方法时，
	 * 先调用这个方法
	 * @param userId
	 * @param model
	 */
//	@ModelAttribute
//	public void preGetSomeInfo(@RequestParam(value="userId",required=false) long userId,
//			Model model,HttpServletRequest request){
//		//获取一些基本信息
//		if(userId==0){//说明没有参数传进来，打开我的首页
//			
//			getSomeInfo(request,model,userSessionId);
//		}else if(userId>0){//参数传进来了，打开主页，可以是自己的 
//			getSomeInfo(request,model,userId);
//		}
//	}
//	
	
	
	private void getSomeInfo(Map<String,Object> map,long userId){
		//获取粉丝的数目
		int userFansSum = commonService.getFansSum(userId);
		//获取关注的人的数目
		int userNoticedSum = commonService.getBeNoticeSum(userId);
		//计算微博总数
		int weiboSum = commonService.getWeiboSum(userId);
		//传给页面
		map.put("user_fans_sum", userFansSum);
		map.put("user_noticed_sum", userNoticedSum);
		map.put("weibo_sum", weiboSum);
	}
	/**
	 * 来到我的首页：获取用户的基本账户信息（USER表）
	 * 通过在session中获取USER_ID来判别当前用户是谁。
	 * （使用拦截器，判断当前浏览器是否存在session：user_id，如果不存在，重定向到登录页面）
	 * @return
	 */
	@RequestMapping(value="tomainpage.do",method=RequestMethod.GET)
	public String toMainPage(HttpServletRequest request,Map<String,Object> map){
		//获取用户id的session
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("user_id");
		System.out.println(userId);
		//除移登录时的错误信息
		session.removeAttribute("login_error");
		//获取信息
		getSomeInfo(map,userId);
		//首页
		return "main";
	}
	
	/**
	 * 根据userId来到用户的主页，显示用户的信息，包括：
	 * 基本信息，微博数目，粉丝数目，关注的人的数目，部分图片6张；
	 * 前20条微博，每条微博的评论数、点赞数、转发数、收藏数
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="tohomepage.do")
	public String toHomePage(@RequestParam(value="userId",required=true) long userId,Map<String,Object> map){
		if(userId==0)
			throw new CantFindThisIdException("无法打开用户主页");
		//获取信息并共享页面
		getSomeInfo(map,userId);
		//获取更多信息
		Userinfo userInfo = commonService.getUserInfo(userId);
		//共享道页面
		map.put("user_info", userInfo);
		return "home";
	}
	
	/**
	 * 获取我的和我关注的人的微博，
	 * @param offset  分页查询的偏移量，每页20条记录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getmineandmynoticeweibo.do",produces={"application/json;charset=utf-8"})
	public List<Weibo> getMineAndMynoticeWeibo(HttpServletRequest request,
			@RequestParam("offset") long offset){
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("user_id");
		//查询
		List<Weibo> weiboList = weiboServcie.getMineAndMynoticeWeibo(userId, offset);
		//以json的形式返回数据
		return weiboList;
	}
	
	/**
	 * 根据用户的id获取他的微博，也就是进入某个用户的主页时，使用ajax异步获取的 微博
	 * @param request
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getoneuserweibo.do",produces={"application/json;charset=utf-8"})
	public List<Weibo> getOneUserWeibo(HttpServletRequest request,
			@RequestParam("userId") long userId,@RequestParam("offset") long offset){
		//一次最多获取20条微博
		List<Weibo> weiboList = weiboServcie.getOneUserWeibo(userId,offset);
		return weiboList;
	}
	
	/**
	 * 发微博
	 * @param weiboContent  微博内容
	 * @param weiboImage  微博上传的图片
	 * @param request
	 * @return
	 */
	@RequestMapping(value="broadcastweibo.do",method=RequestMethod.POST)
	public String broadcastWeibo(@RequestParam("weiboContent") String weiboContent,
			@RequestParam(value="weiboImages",required=false) MultipartFile[] weiboImages,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		User userBaseInfo = (User)session.getAttribute("user_base_info");
		//如果没有上传图片
		if(weiboImages==null || weiboImages.length<=0){
			//装配bean
			Weibo weibo = new Weibo();
			weibo.setUserId(userBaseInfo.getUserId());
			weibo.setUserHeadimage(userBaseInfo.getUserHeadimage());
			weibo.setUserNickname(userBaseInfo.getUserNickname());
			weibo.setWeiboContent(weiboContent);
			weibo.setWeiboImage(null);
			weibo.setWeiboPublishtime(new Timestamp(new Date().getTime()));
			weibo.setWeiboState((byte)0);//微博为没被删除状态
			//插入数据库
			weiboServcie.broadcastWeibo(weibo);
		}else{
			
		}
		return "redirect:tomainpage.do";
	}
}
