package com.jaybill.billblog.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaybill.billblog.email.EmailUtil;
import com.jaybill.billblog.exception.UserAccountException;
import com.jaybill.billblog.exception.UserAccountExistedException;
import com.jaybill.billblog.service.RegistService;
import com.jaybill.billblog.validate.DeleteVerifyCodeUtils;
import com.jaybill.billblog.validate.VerifyCodeUtils;
/**
 * 主要完成注册功能的控制，包括获取验证码：getVerifyCode()、发送邮件submitEmail()
 * @author jaybill
 *
 */
@Controller
@RequestMapping("registcontroller")
public class RegistController {

	@Autowired
	private RegistService service;
	/**
	 * 获取验证码
	 * @param request
	 * @param beforeImg 上一张验证码的图片名，通过路径拼接将其删除
	 * @return
	 */
	@RequestMapping(value="getverifycode")
	@ResponseBody
	public List<String> getVerifyCode(HttpServletRequest request,@RequestParam(value="beforeImg",required=false) String beforeImg){
		//绝对路径
		String path = request.getSession().getServletContext().getRealPath("resource")+"/verifyCode";
		//指向存放验证码的文件夹
		File dir = new File(path);
		//如果有上一张验证码，删除它,只删除点击验证码图片生成的新的图片，刷新页面的图片无法删除
		if(beforeImg.length()==4){
			DeleteVerifyCodeUtils.delBeforeVerifyCodeImgs(path+"/"+beforeImg+".jpg");
		}
		//设置验证码图片的长宽
		int w = 120, h = 30;
		//获取验证码内容
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		//指向验证码图片文件
		File file = new File(dir, verifyCode + ".jpg");
		try {
			//生成验证码
			VerifyCodeUtils.outputImage(w, h, file, verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将生成的验证码图片路径存入List中
		List<String> list = new ArrayList<String>();
		//获取图片的相对路径
		String relativePath = request.getContextPath()+"/resource/verifyCode";
		//添加到链表
		list.add(relativePath+"/"+verifyCode+".jpg");
		list.add(verifyCode);
		return list;
	}
	
	
	/**
	 * 发送邮件
	 * 先将传进来的账户密码存到session，然后发送链接到这个邮箱，
	 * 用户点击这个邮箱，则把账户密码等存到数据库
	 * @param userAccount  用户账户
	 * @param userPassword 用户密码
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="submitemail")
	public String[] submitEmail(@RequestParam("userAccount") String userAccount,
			@RequestParam("userPassword") String userPassword,HttpServletRequest request,
			Map<String,Object> map){
		
		//用户账户抛出异常(因为此处是ajax，抛出异常也跳转不到)
		if(userAccount==null||userAccount.length()<=0){
			String [] userErrorInfo = {"0","输入的账号为空，请重新注册"};
			return userErrorInfo;
		}
		
		//判断这个账号是否被注册,如被注册，抛出异常(因为此处是ajax，抛出异常也跳转不到)
		boolean isExisted=service.isAccountExisted(userAccount);
		if(isExisted){
			String [] userErrorInfo = {"0","当前邮箱已经被注册，请换一个邮箱重新注册"};
			return userErrorInfo;
		}
		
		//存到session
		request.getSession().setAttribute("user_account", userAccount);
		request.getSession().setAttribute("user_password", userPassword);
		//发送邮件		
		try {
			String emailCode = EmailUtil.submitEmail(userAccount); //给emailCode赋值
			request.getSession().setAttribute("email_code", emailCode);//存到session中
		} catch (Exception e) {
			e.printStackTrace();
		}	
		String [] userErrorInfo = {"1"};//0有异常，1表示正常执行
		return userErrorInfo;
	}
	
	/**
	 * 该方法点击邮件上的链接才会触发
	 * 将用户信息填进数据库
	 * @param userAccount
	 * @param session
	 * @return
	 */
	@RequestMapping(value="makesureregist")
	public String makeSureRegist(@RequestParam("inputCode") String inputCode,
			HttpServletRequest request){
		//判断输入的邮箱验证码和emailCode是否相等			
		System.out.println("emailCode:"+request.getSession().getAttribute("email_code"));
		if(inputCode!=null&&inputCode.equals(request.getSession().getAttribute("email_code"))){
			//获取账号密码
			String userAccount = (String)request.getSession().getAttribute("user_account");
			String userPassword = (String)request.getSession().getAttribute("user_password");
			//添加用户
			long userId = service.addUser(userAccount, userPassword);
			//除移之前保存的账户、密码的session
			request.getSession().removeAttribute("user_account");
			request.getSession().removeAttribute("user_password");
			//将用户的id保存到session
			request.getSession().setAttribute("user_id",userId);
			//为了防止用户刷新页面报错，重定向到安全页面
			//在同一个应用程序内，重定向不会使得session失效
			return "redirect:/weibocontroller/tomainpage.do";
		}else{
			throw new UserAccountException("输入的邮箱验证码错误！");
		}
	}
}
