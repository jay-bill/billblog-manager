package com.jaybill.billblog.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.AttentionService;
import com.jaybill.billblog.service.CommonService;

@Controller
@RequestMapping("attentioncontroller")
public class AttentionController {
	
	@Autowired
	private AttentionService attentionService;
	@Autowired
	private CommonService commonService;
	/**
	 * 搜索结果页面加载完成后，通过ajax判断关注关系。
	 * @param beNoticedId
	 * @param request
	 * @param type 0表示判断自己是否关注别人，1表示判断别是否关注自己
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="judgeattention.do",method=RequestMethod.GET)
	public String[] judgeAttention(@RequestParam(value="beNoticedId") long beNoticedId,
			@RequestParam("method") int type,HttpServletRequest request){
		HttpSession session = request.getSession();
		//当前使用者的id
		long noticerId = -1;
		if(session.getAttribute("user_id")!=null){
			noticerId = (long)session.getAttribute("user_id");
		}
		String [] res = attentionRelative(noticerId, beNoticedId);//判断关注关系
		return res;
	}
	/**
	 * 判断关注关系
	 * @param noticerId
	 * @param beNoticedId
	 * @return
	 */
	private String[] attentionRelative(long noticerId,long beNoticedId){
		//如果传进来的是自己的id
		if(noticerId == beNoticedId)
			return new String[]{"2"};
		int res1 = attentionService.isAlreadyNoticed(noticerId, beNoticedId);//判断自己是否关注别人
		int res2 = attentionService.isAlreadyNoticed(beNoticedId, noticerId);//判断自己是否被别人关注
		if(res1==1&&res2==0){
			return new String[]{"1"};//表示自己已关注别人，但别人没关注自己
		}else if(res2==1&&res1==1){
			return new String[]{"3"};//表示相互关注
		}
		return new String[]{"0"};//没关注
	}
	/**
	 * 关注某个用户
	 * @param beNoticedId  被关注者的id，如果不存在，抛出异常
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addattention.do",method=RequestMethod.POST)
	public String[] addAttention(@RequestParam("beNoticedId") long beNoticedId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		//当前使用者的id
		long noticerId = (long)session.getAttribute("user_id");
		//不允许自己关注自己
		if(noticerId == beNoticedId)
			return new String[]{"2"};
		int result = attentionService.insertAttention(noticerId, beNoticedId);
		if(result==0){//没有插入成功
			return null;
		}
		//返回1，关注成功
		return new String[]{"1"};
	}
	
	/**
	 * 取消关注
	 * @param beNoticedId 不再被关注的id
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="avoidattention.do")
	public String[] avoidAttention(@RequestParam("beNoticedId") long beNoticedId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		//当前使用者的id
		long noticerId = (long)session.getAttribute("user_id");
		//取消关注
		int res=attentionService.deleteAttention(noticerId, beNoticedId);
		//失败
		if(res==0)
			return null;
		//成功，随便返回一个值
		return new String[]{"1"};
	}
	
	/**
	 * 来到粉丝列表页面，采用分页的方式显示，每页显示10个
	 */
	@RequestMapping(value="tofanslistpage.do")
	public String toFansListPage(@RequestParam("userId") long userId,
			Map<String,Object> map){
		//获取分页数
		int userFansSum  =commonService.getFansSum(userId);
		//关注数
		//微博数
		int weiboSum = commonService.getWeiboSum(userId);
		//获取该userId的信息
		User otherUserBaseInfo = commonService.getUserBaseInfo(userId);
		Userinfo otherUserInfo = commonService.getUserInfo(userId);
		int userBeNoticedSum  =commonService.getBeNoticeSum(userId);
		map.put("user_noticed_sum", userBeNoticedSum);
		//共享页面
		map.put("user_fans_sum", userFansSum);
		map.put("other_user_id", userId);
		map.put("other_user_base_info", otherUserBaseInfo);
		map.put("user_info", otherUserInfo);
		map.put("weibo_sum", weiboSum);
		//直接返回页面
		return "fans-list";
	}
	
	/**
	 * 获取粉丝或者关注的基本信息、详细信息
	 * @param offset
	 * @param userId
	 * @return
	 */
	@RequestMapping("getfansuserlist.do")
	@ResponseBody
	public List<Object> getFansUserList(@RequestParam("offset") long offset,
			@RequestParam("userId") long userId,HttpServletRequest request){
		HttpSession session = request.getSession();
		//当前使用者的id
		long myId = -1;//游客
		if(session.getAttribute("user_id")!=null){
			myId = (long)session.getAttribute("user_id");
		}
		//根据当前用户id，获取粉丝基本信息
		List<User> user = attentionService.getFansUser(userId,offset);
		List<Object> res= getSomeInfo(user,myId, userId, offset);//获取信息
		return res;
	}
	
	/**
	 * 获取进入关注、粉丝列表所需要的信息
	 * @param myId
	 * @param userId
	 * @param offset
	 * @return
	 */
	private List<Object> getSomeInfo(List<User> user,long myId,long userId,long offset){
		//粉丝数
		List<Integer> fanList = new ArrayList<Integer>();
		//关注数
		List<Integer> noticeList = new ArrayList<Integer>();
		//微博数
		List<Integer> weiboList = new ArrayList<Integer>();
		//自己与其他用户（或自己）的每位粉丝的关注关系
		List<String []> relaList = new ArrayList<String[]>();
		//用户详细信息
		List<Userinfo> infoList = new ArrayList<Userinfo>();
		//获取每位粉丝的粉丝数、关注数、微博数
		Iterator<User> it = user.iterator();
		while(it.hasNext()){
			User u = it.next();
			fanList.add(commonService.getFansSum(u.getUserId()));//添加该用户粉丝数
			noticeList.add(commonService.getBeNoticeSum(u.getUserId()));//该用户关注数
			weiboList.add(commonService.getWeiboSum(u.getUserId()));//添加该用户的微博数
			relaList.add(attentionRelative(myId,u.getUserId()));//添加关注关系
			infoList.add(commonService.getUserInfo(u.getUserId()));//该用户详细信息
		}
		//返回到ajax
		List<Object> objList = new ArrayList<Object>();
		/*
		 * objList[0]：用户信息，objList[1]：粉丝数列表，objList[2]:关注数列表,objList[3]:微博数列表，
		 * objList[4]:关注关系， objList[5]:用户详细信息
		 */		
		objList.add(user);
		objList.add(fanList);
		objList.add(noticeList);
		objList.add(weiboList);
		objList.add(relaList);
		objList.add(infoList);
		return objList;
	}
	/**
	 * 和粉丝列表类似；每页显示5条记录。
	 * @param offset
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="tonoticelistpage.do")
	public String toNoticeListPage(@RequestParam("userId") long userId,Map<String,Object> map){
		//获取分页数
		int userBeNoticedSum  =commonService.getBeNoticeSum(userId);
		//获取该userId的信息
		User otherUserBaseInfo = commonService.getUserBaseInfo(userId);
		Userinfo otherUserInfo = commonService.getUserInfo(userId);
		//粉丝数
		int fansSum = commonService.getFansSum(userId);
		//微博数
		int weiboSum = commonService.getWeiboSum(userId);
		//共享页面
		map.put("user_noticed_sum", userBeNoticedSum);
		map.put("user_fans_sum", fansSum);
		map.put("weibo_sum", weiboSum);
		map.put("other_user_base_info", otherUserBaseInfo);
		map.put("user_info", otherUserInfo);
		return "notice-list";
	}
	
	/**
	 * 获取notice基本信息列表
	 * @param offset
	 * @param userId
	 * @return
	 */
	@RequestMapping("getnoticeuserlist.do")
	@ResponseBody
	public List<Object> getNoticeUserList(@RequestParam("offset") long offset,
			@RequestParam("userId") long userId,
			HttpServletRequest request){
		//根据当前用户id，获取粉丝基本信息
		List<User> user = attentionService.getBeNoticedUser(userId,offset);	
		HttpSession session = request.getSession();
		//当前使用者的id
		long myId = -1;//游客
		if(session.getAttribute("user_id")!=null){
			myId = (long)session.getAttribute("user_id");
		}
		if(user.size()==0)
			return null;
		//返回到ajax
		List<Object> objList = getSomeInfo(user, myId, userId, offset);
		return objList;
	}
}
