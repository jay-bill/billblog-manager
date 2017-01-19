package com.jaybill.billblog.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.CommonService;

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
	
	/**
	 * 来到首页：获取用户的基本账户信息（USER表）
	 * 通过在session中获取USER_ID来判别当前用户是谁。
	 * （使用拦截器，判断当前浏览器是否存在session：user_id，如果不存在，重定向到登录页面）
	 * @return
	 */
	@RequestMapping(value="tomainpage.do",method=RequestMethod.GET)
	public String toMainPage(HttpServletRequest request,Map<String,Object> map){
		//观察是否能正常获取用户id的session
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("user_id");
		System.out.println(userId);
		//除移登录时的错误信息
		session.removeAttribute("login_error");
		//获取账号的基本信息，即表USER里面的内容
		User userBaseInfo = commonService.getUserBaseInfo(userId);
		//获取粉丝的数目
		int userFansSum = commonService.getFansSum(userId);
		//获取关注的人的数目
		int userNoticedSum = commonService.getBeNoticeSum(userId);
		//计算微博总数
		int weiboSum = commonService.getWeiboSum(userId);
		//传给页面
		map.put("user_base_info", userBaseInfo);
		map.put("user_fans_sum", userFansSum);
		map.put("user_noticed_sum", userNoticedSum);
		map.put("weibo_sum", weiboSum);
		return "main";//首页
	}
}
