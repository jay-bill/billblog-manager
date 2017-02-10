package com.jaybill.billblog.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
import com.jaybill.billblog.exception.ImageFormatException;
import com.jaybill.billblog.mapper.LikeitMapper;
import com.jaybill.billblog.pojo.Comments;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.Likeit;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.pojo.Weibo;
import com.jaybill.billblog.service.CommentService;
import com.jaybill.billblog.service.CommonService;
import com.jaybill.billblog.service.LikeService;
import com.jaybill.billblog.service.WeiboService;

/**
 * 微博控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping("weibocontroller")
public class WeiboController {
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private WeiboService weiboService;
	@Autowired
	private LikeService likeService;
	@Autowired
	private CommentService commentService;

	public WeiboController(){
		System.out.println("weibo控制器实例化啦！");
	}
	
	private void getSomeInfo(Map<String,Object> map,long userId){
		//粉丝总数
		int userFansSum = commonService.getFansSum(userId);
		//关注总数
		int userNoticedSum = commonService.getBeNoticeSum(userId);
		//微博总数
		int weiboSum = commonService.getWeiboSum(userId);
		//未读通知的数目
		int noReadSum = commonService.selectSumNoRead(userId);
		//共享到页面
		map.put("user_fans_sum", userFansSum);
		map.put("user_noticed_sum", userNoticedSum);
		map.put("weibo_sum", weiboSum);
		map.put("no_read_sum", noReadSum);
	}
	/**
	 *来到首页：根据用户的存到session中的user_id，在数据库中获取基本信息
	 * @return
	 */
	@RequestMapping(value="tomainpage.do",method=RequestMethod.GET)
	public String toMainPage(HttpServletRequest request,Map<String,Object> map){
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("user_id");
		session.removeAttribute("login_error");
		//获取一些信息
		getSomeInfo(map,userId);
		//返回
		return "main";
	}
	
	/**
	 * 根据用户传进来的id，获取相关信息
	 * @param request
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="tohomepage.do")
	public String toHomePage(@RequestParam(value="userId",required=true) long userId,Map<String,Object> map){
		if(userId==0)
			throw new CantFindThisIdException("鏃犳硶鎵撳紑鐢ㄦ埛涓婚〉");
		//获取一些信息
		getSomeInfo(map,userId);
		//基本信息
		User otherUserBaseInfo = commonService.getUserBaseInfo(userId);
		//详细信息
		Userinfo userInfo = commonService.getUserInfo(userId);
		//共享到页面
		map.put("user_info", userInfo);
		map.put("other_user_base_info", otherUserBaseInfo);
		return "home";
	}
	
	/**
	 * 获取我的和我关注的人的微博
	 * @param offset  分页
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getmineandmynoticeweibo.do",produces={"application/json;charset=utf-8"})
	public List<Object> getMineAndMynoticeWeibo(HttpServletRequest request,
			@RequestParam("offset") long offset){
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("user_id");
		//获取微博
		List<Weibo> weiboList = weiboService.getMineAndMynoticeWeibo(userId, offset);
		//加工微博
		List<Object> list = getWeibo(weiboList,userId,request);
		return list;
	}
	
	/**
	 * 获取某个用户的微博，即进入他的主页
	 * @param request
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getoneuserweibo.do",produces={"application/json;charset=utf-8"})
	public List<Object> getOneUserWeibo(HttpServletRequest request,
			@RequestParam("userId") long userId,@RequestParam("offset") long offset){
		//微博
		List<Weibo> weiboList = weiboService.getOneUserWeibo(userId,offset);		
		//自己的id
		long myId = (long)request.getSession().getAttribute("user_id");
		List<Object> list = getWeibo(weiboList,myId,request);
		return list;
	}	
	
	/**
	 * 加工微博
	 * @param weiboList
	 * @param userId
	 * @return
	 */
	private List<Object> getWeibo(List<Weibo> weiboList,long userId,HttpServletRequest request){
		//存放每条微博点赞数的list
		List<Integer> likeSumList = new ArrayList<Integer>();
		//存放判断每条微博是否被自己点赞的list
		List<Integer> isLikedList = new ArrayList<Integer>();
		//存放每条微博的评论总数的list
		List<Integer> comSumList = new ArrayList<Integer>();
		
		Iterator<Weibo> it = weiboList.iterator();
		while(it.hasNext()){
			Weibo weibo = it.next();
			switch(weibo.getWeiboState()){
				case 0: //默认状态
						//微博点赞数
						int sum = likeService.getLikeSum(weibo.getWeiboId());
						//自己是否点赞
						int isLike = likeService.selectIsAlreadyLike(userId, weibo.getWeiboId());
						//评论数
						int commentSum = commentService.getCommentSum(weibo.getWeiboId());
						//添加
						likeSumList.add(sum);
						isLikedList.add(isLike);
						comSumList.add(commentSum);
						break;
				case 1://删除状态
						break;
				case 2:	//转发状态
						//获取微博的内容：自己转发时的内容@_@被转发微博的id
						String weiboAllContent = weibo.getWeiboContent(); 
						/*
						 * 解析后的微博内容
						 */
						String newContent = getOriWeibo(weiboAllContent,request);
						//修正新内容
						String fixNewContent;
						if(newContent.equals("##$$%&$*&##")){
							fixNewContent = weiboAllContent.split("@_@")[0]+"<br>原微博已被删除";
						}else{
							fixNewContent = weiboAllContent.split("@_@")[0]+newContent;
						}
						
						//赋值给weibo
						weibo.setWeiboContent(fixNewContent);
						//获取点赞数
						int sum2 = likeService.getLikeSum(weibo.getWeiboId());
						//是否点赞
						int isLike2 = likeService.selectIsAlreadyLike(userId, weibo.getWeiboId());
						//评论数
						int commentSum2 = commentService.getCommentSum(weibo.getWeiboId());
						//添加
						likeSumList.add(sum2);
						isLikedList.add(isLike2);
						comSumList.add(commentSum2);
						break;
				default:break;
			}
		}
		//list[0]为微博，list[1]为点赞数列表，list[3]为是否点赞（0为没点赞），list[4]为评论总数
		List<Object> list = new ArrayList<Object>();
		list.add(weiboList);
		list.add(likeSumList);
		list.add(isLikedList);
		list.add(comSumList);
		return list;
	}
	/**
	 * 解析微博
	 * @param weiboContent
	 * @return
	 */
	private String getOriWeibo(String weiboContent,HttpServletRequest request) {
		String [] res = StringUtils.split(weiboContent, "@_@");
		StringBuilder sb = new StringBuilder();
		if(res.length==2){
			//根据id获取微博
			Weibo weibo = weiboService.getOneWeiboById(Long.parseLong(res[1]));
			if(weibo==null){
				return "##$$%&$*&##";
			}
			String resStr = getOriWeibo(weibo.getWeiboContent(),request);
			if(resStr!=null && resStr.contains("##$$%&$*&##")){
				return "##$$%&$*&##";
			}else if(!resStr.contains("@_@")){ 
					int likeSumOri = likeService.getLikeSum(weibo.getWeiboId());
					int isLikeOri = likeService.selectIsAlreadyLike(
									(long)request.getSession().getAttribute("user_id"), 
									weibo.getWeiboId());
					int commentSumOri = commentService.getCommentSum(weibo.getWeiboId());
					sb.insert(0,"@_@"+weibo.getUserHeadimage()+"@_@"+weibo.getUserNickname()+
							"@_@"+weibo.getWeiboPublishtime()+"@_@"+weibo.getWeiboContent()+
							"@_@"+weibo.getWeiboImage()+
							"@_@"+weibo.getUserId()+"@_@"+weibo.getWeiboId()+"@_@"+likeSumOri+
							"@_@"+isLikeOri+"@_@"+commentSumOri);
			}else{
				sb.insert(0, "@"+weibo.getUserNickname()+":"+
								weibo.getWeiboContent().split("@_@")[0]+resStr);
			}
		}else{
			sb.append("");			
		}		
		return sb.toString();
	}
	/**
	 * 发微博
	 * @param weiboContent 内容
	 * @param weiboImage  图片
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="broadcastweibo.do",method=RequestMethod.POST)
	public String broadcastWeibo(@RequestParam("weiboContent") String weiboContent,
			@RequestParam(value="weiboImages",required=false) MultipartFile[] weiboImages,
			HttpServletRequest request) throws IllegalStateException, IOException{
		HttpSession session = request.getSession();
		User userBaseInfo = (User)session.getAttribute("user_base_info");
		if(weiboContent.length()<=0)
			return "redirect:tomainpage.do";
		Weibo weibo = null;
		//判断是否上传图片
		if(weiboImages==null || weiboImages.length<=0||weiboImages[0].getOriginalFilename().isEmpty()){
			//装配bean
			weibo = new Weibo(userBaseInfo.getUserId(),userBaseInfo.getUserNickname(),
							new Timestamp(new Date().getTime()),userBaseInfo.getUserHeadimage(),
							weiboContent,(byte)0,null);
		}else{
			String imagesPath = uploadWeiboImages(weiboImages,request);
			//装配bean
			weibo = new Weibo(userBaseInfo.getUserId(),userBaseInfo.getUserNickname(),
							new Timestamp(new Date().getTime()),userBaseInfo.getUserHeadimage(),
							weiboContent,(byte)0,imagesPath);
		}
		//插入数据库
		weiboService.broadcastWeibo(weibo);
		//返回main
		return "redirect:tomainpage.do";
	}
	
	/**
	 * 上传图片
	 * @param images
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private String uploadWeiboImages(MultipartFile[] images,HttpServletRequest request) throws IllegalStateException, IOException{ 		
		//先获取服务器写个文件tomcat/webapps/billblog-manager-controller
		String userImagesFilePath = request.getSession().getServletContext().getRealPath("userImages");
		//指向文件夹
		File userImagesFile = new File(userImagesFilePath);
		//如果没有，创建
		if(!userImagesFile.exists()){
			userImagesFile.mkdirs();
		}
		//先对图片重命名
		//然后将重命名的每张图片以%%隔开
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<images.length;i++){
			String originalFilename = images[i].getOriginalFilename();//获取元素文件名
			String [] splitedStr = StringUtils.split(originalFilename,".");//分隔
			String suffixStr = splitedStr[splitedStr.length-1];//获取后缀
			//根据后缀判断是否为图片，如果存在非图片，则抛出异常
			if(suffixStr.equals("jpg") || suffixStr.equals("jpeg") || suffixStr.equals("png") || suffixStr.equals("gif")||
					suffixStr.equals("tiff")||suffixStr.equals("pcx")||suffixStr.equals("psd")||suffixStr.equals("exif")||
					suffixStr.equals("fpx")||suffixStr.equals("svg")||suffixStr.equals("cdr")||suffixStr.equals("pcd")||
					suffixStr.equals("dxf")||suffixStr.equals("ufo")||suffixStr.equals("eps")||suffixStr.equals("ai")||
					suffixStr.equals("raw")){
				//根据实际命名图片
				String prefixStr = "billblog"+new Date().getTime()+""+i;
				//合并名称
				String imageName = prefixStr+"."+suffixStr;
				//全路径，包括文件夹和文件名
				String imagePathAndName = userImagesFilePath+"\\"+imageName;
				//指向文件图片
				File imageFile = new File(imagePathAndName);
				//赋值
				images[i].transferTo(imageFile);
				//获取相对路径存入数据库
				String relativePath = request.getContextPath()+"/userImages/"+imageName;
				sb.append(relativePath+"%%");
			}else{
				throw new ImageFormatException("必须为图片！");
			}
		}
		return sb.toString();//返回组装后的相对路径，每张图片以%%隔开
	}
	
	/**
	 * 删除微博
	 * @param weiboId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteweibo.do")
	public String[] deleteWeibo(@RequestParam("weiboId") long weiboId){
		int res =weiboService.deleteWeibo(weiboId);
		if(res==0)
			return null;
		return new String[]{"1"};
	}
	
	/**
	 * 转发微博
	 * @param weiboContent 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="forwardweibo.do",method=RequestMethod.POST)
	public String forwardWeibo(@RequestParam("myContent") String myContent,
			@RequestParam("beForwardWeiboId") String beForwardWeiboId,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		User userBaseInfo = (User)session.getAttribute("user_base_info");
		if(myContent==null||myContent.length()<=0){
			myContent="转发微博";
		}
		//自己的内容@_@原微博的id
		String weiboContent = myContent+"@_@"+beForwardWeiboId;
		//装配bean
		Weibo weibo = new Weibo(userBaseInfo.getUserId(),userBaseInfo.getUserNickname(),
						new Timestamp(new Date().getTime()),userBaseInfo.getUserHeadimage(),
						weiboContent,(byte)2,null);
		//插入数据库
		weiboService.broadcastWeibo(weibo);
		//为了防止重新提交表单，重新向到首页
		return "redirect:tomainpage.do";
	}
	
	/**
	 * 来到通知页面，“与我相关”
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="toreadinfo.do")
	public String toReadInfo(HttpServletRequest request,Map<String,Object> map){
		HttpSession session = request.getSession();
		long userId = (long)session.getAttribute("user_id");
		//存放原始微博
		List<Weibo> weiboList = new ArrayList<Weibo>();
		//存放User
		List<User> userList = new ArrayList<User>();
		//存放
		//获取Info实例
		List<Info> infoList = commonService.selectByBeinfoId(userId);		
		Iterator<Info> it = infoList.iterator();
		while(it.hasNext()){
			//每条通知
			Info info = it.next();
			//获取通知里面的消息
			String infoContent = info.getInfoContent();
			//因为他的格式为 id@_@XXXX，即已@_@为分割
			long oriContentId = Long.parseLong(StringUtils.split(infoContent, "@_@")[0]);
			//设置Info的内容
			info.setInfoContent(StringUtils.split(infoContent, "@_@")[1]);
			//根据oriContentId从数据库获取原始内容
			if(oriContentId!=0){
				Weibo weibo = weiboService.getOneWeiboById(oriContentId);
				//取出第一张图片
				if(weibo.getWeiboImage()!=null){
					weibo.setWeiboImage(StringUtils.split(weibo.getWeiboImage(),"%%")[0]);
				}
				if(weibo.getWeiboContent().contains("@_@")){
					weibo.setWeiboContent(StringUtils.split(weibo.getWeiboContent(), "@_@")[0]);
				}
				weiboList.add(weibo);
			}else{
				weiboList.add(new Weibo());
			}
			//根据通知者的id获取通知者的信息
			userList.add(commonService.getUserBaseInfo(info.getInfoId()));
		}
		//浏览过这些通知之后，把数据库的通知状态列为已阅读
		commonService.updateInfoState(userId);
		//共享到页面
		map.put("infoList", infoList);
		map.put("info_weiboList", weiboList);
		map.put("other_user_base_info", userList);
		return "info";
	}
	
	/**
	 * 打开一条微博的页面
	 * @param weiboId
	 * @param map
	 * @return
	 */
	@RequestMapping("tooneweibopage.do")
	public String toOneWeiboPage(@RequestParam("weiboId") long weiboId,Map<String,Object>map){
//		//根据weibo发id获取微博
//		Weibo weibo = weiboService.getOneWeiboById(weiboId);
//		//将图片单独取出来
//		String imgPath = weibo.getWeiboImage();
//		String [] images = StringUtils.split(imgPath,"%%");
//		weibo.setWeiboImage(null);
//		//评论总数，点赞总数
//		int likeSum = likeService.getLikeSum(weiboId);
//		int cmtSum = commentService.getCommentSum(weiboId);
//		//评论内容
//		List<Comments> commentList= commentService.getComments(weiboId, 0);
//		//评论者的基本信息
//		List<User> userList = new ArrayList<User>();
//		//获取评论者的头像、昵称
//		for(int i=0;i<commentList.size();i++){
//			userList.add(commonService.getUserBaseInfo(commentList.get(i).getCommentReviewerid()));
//		}
//		map.put("one_weibo", weibo);
//		map.put("one_weibo_images", images);
//		map.put("comment_list",commentList);
//		map.put("like_sum", likeSum);
//		map.put("comment_sum", cmtSum);
//		map.put("other_user_base_info_list", userList);
		map.put("weibo_id", weiboId);
		return "one-weibo";
	}
	
	/**
	 * 根据微博id获取微博的
	 * 相关信息
	 * @param weiboId
	 * @param request
	 * @return
	 */
	@RequestMapping("getoneweibo.do")
	@ResponseBody
	public List<Object> getOneWeibo(@RequestParam("weiboId") long weiboId,
			HttpServletRequest request){
		long userId = (long)request.getSession().getAttribute("user_id");
		//根据weibo发id获取微博
		Weibo weibo = weiboService.getOneWeiboById(weiboId);
		if(weibo.getWeiboContent().contains("@_@")){
			String str = weibo.getWeiboContent();
			weibo.setWeiboContent(StringUtils.split(str,"@_@")[0]);
		}
		//评论总数，点赞总数
		int likeSum = likeService.getLikeSum(weiboId);
		//自己是否点赞
		int isLike = likeService.selectIsAlreadyLike(userId, weiboId);
		int cmtSum = commentService.getCommentSum(weiboId);
		//装配成List
		List<Object> objList = new ArrayList<Object>();
		objList.add(weibo);
		objList.add(likeSum);
		objList.add(isLike);
		objList.add(cmtSum);
		return objList;
	}
}
