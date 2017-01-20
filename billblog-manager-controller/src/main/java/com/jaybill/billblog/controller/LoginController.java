package com.jaybill.billblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.LoginService;

/**
 * 登录 控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping("logincontroller")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	/**
	 * 登录
	 * 先将用户的账号密码拿到数据库比对；
	 * 如果相同，则获取返回用户的id值；把id存到session中
	 * 如果不同，提示用户错误信息
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user){
		//判断用户、秘密吗是否允许登录
		User beSelectedUser = loginService.login(user);
		//session
		HttpSession session = request.getSession();
		//如果获取的值为空
		if(beSelectedUser==null){
			session.setAttribute("login_error", "账号或密码错误！请重新输入");
			return "redirect:/index.jsp";//回到登录页面
		}
		//如果获取的值不为空
		//将用户id存到session里面
		session.setAttribute("user_id", beSelectedUser.getUserId());//用户id存到session里面
		//将基本信息存到session里面——当前用户
		session.setAttribute("user_base_info", beSelectedUser);
		//因为是post方式提交，所以重定向到tomainpage方法
		return "redirect:/weibocontroller/tomainpage.do";
	}
	
	/**
	 * 登出，判断当前浏览器是否有session，若没有，直接返回登录页面；
	 * 若有，除移属性，再返回index页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="loginout")
	public String loginOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session==null)
			return "redirect:/index.jsp";
		//除移用户唯一标识
		session.removeAttribute("user_id");
		return "redirect:/index.jsp";
	}
}
