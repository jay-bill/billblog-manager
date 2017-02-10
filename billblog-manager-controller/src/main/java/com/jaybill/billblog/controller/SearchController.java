package com.jaybill.billblog.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaybill.billblog.exception.UserCantFound;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.CommonService;
import com.jaybill.billblog.service.SearchService;

/**
 * 查找功能 控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping(value="searchcontroller")
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	@Autowired
	private CommonService commonService;
	/**
	 * 根据传进来的用户昵称进行查询，只能进行精确查询，去掉输入的空格
	 * @param userNickname
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="searchUser.do")
	public String searchUser(@RequestParam(value="userNickname") String userNickname,
			Map<String,Object> map) throws UnsupportedEncodingException{
		String userNicknameEncode = new String(userNickname.getBytes("ISO-8859-1"),"utf-8");
		//获取基本信息
		User userBySearch = searchService.selectUserByNickname(userNicknameEncode);		
		if(userBySearch==null){
			throw new UserCantFound("该用户不存在，请确认您的关键词");
		}
		//如果能获取到信息		
		long userId = userBySearch.getUserId();
		//获取详细信息
		Userinfo userInfo = commonService.getUserInfo(userId);
		//计算粉丝数
		int userFansSum = commonService.getFansSum(userId);
		//计算关注数
		int userNoticedSum = commonService.getBeNoticeSum(userId);
		//计算微博总数
		int weiboSum = commonService.getWeiboSum(userId);
		//共享到页面
		map.put("user_base_info_bysearch", userBySearch);
		map.put("user_fans_sum", userFansSum);
		map.put("user_noticed_sum", userNoticedSum);
		map.put("weibo_sum", weiboSum);
		map.put("user_info", userInfo);
		//返回查询结果页面
		return "search-result";	
	}
	
	
}
