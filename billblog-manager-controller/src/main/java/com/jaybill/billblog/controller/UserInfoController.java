package com.jaybill.billblog.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.CommonService;

/**
 * 用户信息控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping("userinfocontroller")
public class UserInfoController{
	
	@Autowired
	private CommonService commonService;
	
	/**
	 * 执行这个控制器的任何@RequestMapping标注的方法之前，先执行这个方法！
	 * 将userInfo作为key放到model对象中，可以在页面 上获取；
	 * 当调用saveUserInfo方法时，先判断是否存在userInfo对象，如果存在，直接使用这个对象；
	 * 如果不存在，通过反射创建Userinfo对象，再使用request获取参数，set到对象里面。
	 */
//	@ModelAttribute("userInfo")
//	public Userinfo preGetUserInfo(@RequestParam long userId,Model model){
//		Userinfo userInfo = commonService.getUserInfo(userId);	
//		model.addAttribute("user_info",userInfo);//用户基本信息
//		return userInfo;
//	}
	
	/**
	 * 获取用户的详细信息
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("touserinfo.do")
	public String toUserInfo(@RequestParam(value="userId",required=true) long userId,
			HttpServletRequest request,Map<String,Object> map){
		//获取信息
		User userBaseInfo = commonService.getUserBaseInfo(userId);
		Userinfo userInfo = commonService.getUserInfo(userId);	
		int userFansSum = commonService.getFansSum(userId); //粉丝数
		int userNoticedSum = commonService.getBeNoticeSum(userId);//关注的人数
		int weiboSum = commonService.getWeiboSum(userId);//微博总数
		//发送到页面
		map.put("user_base_info", userBaseInfo);
		map.put("user_info", userInfo);
		map.put("user_fans_sum", userFansSum);
		map.put("user_noticed_sum", userNoticedSum);
		map.put("weibo_sum", weiboSum);
		//返回视图
		return "user-info";
	}
	
	/**
	 * 保存更新的用户信息
	 * @param userInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="saveuserinfo.do",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public String[] saveUserInfo(Userinfo userInfo,@RequestParam("userNickname") String userNickname,
			HttpServletRequest request){	
		//装配成user
		User user = new User();
		long userId = (long)request.getSession().getAttribute("user_id");
		user.setUserNickname(userNickname);
		user.setUserId(userId);
		userInfo.setUserId(userId);
		//更新信息
		commonService.updateUserInfo(user,userInfo);
		//更新存在user_base_info里面的内容
		User userBase = (User)request.getSession().getAttribute("user_base_info");
		if(userBase!=null)
			userBase.setUserNickname(userNickname);
		//为了能在ajax执行success只需返回一个空值即可；如果返回null则执行ajax里面的error
		String [] returnValue={};
		return returnValue;
	}
}
