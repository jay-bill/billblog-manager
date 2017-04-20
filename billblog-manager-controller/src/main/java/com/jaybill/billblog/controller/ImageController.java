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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jaybill.billblog.exception.CantUpdateHeadImageException;
import com.jaybill.billblog.exception.ImageFormatException;
import com.jaybill.billblog.image.CompressImg;
import com.jaybill.billblog.mapper.ImageMapper;
import com.jaybill.billblog.pojo.Image;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.CommonService;
import com.jaybill.billblog.service.ImageService;

/**
 * 图片功能 控制器
 * @author jaybill
 *
 */
@Controller
@RequestMapping(value="imagecontroller")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private CommonService commonService;
	/**
	 * 更换头像
	 * @param headImage
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="updateheadimage.do",method=RequestMethod.POST)
	public String updateHeadImage(@RequestParam("headImage") MultipartFile headImage,
			HttpServletRequest request) throws IllegalStateException, IOException{
		HttpSession session = request.getSession();
		long userId = (long) session.getAttribute("user_id");
		String headImagePath = handleHeadImage(headImage, request);
		//更新数据库，只需更新user表，因为他是主表且外键约束为cascade，其他的表如weibo等会随着主表更新而被更新
		int res = imageService.updateHeadimage(userId, headImagePath);
		if(res==0){
			throw new CantUpdateHeadImageException("头像上传失败，请稍后重试");
		}
		//更新之前存到user_base_info中的头像路径
		User user = (User)session.getAttribute("user_base_info");
		user.setUserHeadimage(headImagePath);
		//为了反正重复提交表单，重定向到主页
		return "redirect:/weibocontroller/tohomepage.do?userId="+userId;
	}
	
	/**
	 * 创建存放图片的文件夹，
	 * 为图片重命名，
	 * 保存图片，
	 * 截取相对路径返回
	 * @param headImage
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	private String handleHeadImage(MultipartFile headImage,HttpServletRequest request) throws IllegalStateException, IOException{
		//先获取服务器写个文件tomcat/webapps/billblog-manager-controller
		String userImagesFilePath = request.getSession().getServletContext().getRealPath("userImages");
		//指向文件夹
		File userImagesFile = new File(userImagesFilePath);
		//如果没有，创建
		if(!userImagesFile.exists()){
			userImagesFile.mkdirs();
		}
		String originalFilename = headImage.getOriginalFilename();//获取元素文件名
		String [] splitedStr = StringUtils.split(originalFilename,".");//分隔
		String suffixStr = splitedStr[splitedStr.length-1];//获取后缀
		//压缩图片的图片名称，压缩
		String compressStr = "billblog"+new Date().getTime();
		//根据实际命名图片
		String prefixStr = compressStr+"big";
		//合并名称
		//原图
		String imageName = prefixStr+"."+suffixStr;
		//压缩图
		String compImageName = compressStr+"."+suffixStr;
		//全路径，包括文件夹和文件名
		String imagePathAndName = userImagesFilePath+File.separator+imageName;
		//指向文件图片
		File imageFile = new File(imagePathAndName);
		//复制图片，保存了原图
		headImage.transferTo(imageFile);
		//再把原图进行压缩
		CompressImg compressImg = new CompressImg();
		//参数依次为：原图所在目录，压缩图所在目录，原图名称，压缩图名称，压缩图宽，压缩图高，是否按比例压缩
		compressImg.compressPic(userImagesFilePath, userImagesFilePath, imageName, compImageName, 200, 200, false);
		//获取相对路径存入数据库
		String relativePath = request.getContextPath()+File.separator+"userImages"+File.separator+compImageName;
		return relativePath;
	}
	
	/**
	 * 来到相册页面
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("tophotopage.do")
	public String toPhotoPage(@RequestParam("userId") long userId,Map<String,Object> map){
		//获取基本信息，共享到页面
		//基本信息
		User otherUserBaseInfo = commonService.getUserBaseInfo(userId);
		//详细信息
		Userinfo userInfo = commonService.getUserInfo(userId);
		//所有分组的分组图片数目
		List<Integer> defalutImageSum = commonService.getDefaultImageGroupSum(userId);
		List<Integer> list = dividePage(defalutImageSum);
		//共享到页面
		map.put("other_user_base_info", otherUserBaseInfo);
		map.put("user_info", userInfo);
		map.put("defalut_image_sum", defalutImageSum.size());
		map.put("page_imagesum_list", list);
		return "photo";
	}
	/**
	 * 分页
	 * @param defalutImageSum
	 * @return
	 */
	private List<Integer>  dividePage(List<Integer> defalutImageSum){
		//对defalutImageSum处理：每5个依次相加，并添加到List<Integer>里面，共享到页面，与页面的分页想对应
		List<Integer> list = new ArrayList<Integer>();
		int num = 0;
		for(int i=0;i<defalutImageSum.size();i=i+5){
			list.add(num);//外层循环进来一次，就添加一次，添加进去的是每个分页起始的图片数。
			if(defalutImageSum.size()-i<=5){//循环到最后一次，
				break;//循环到最后一次，不用计算数目了
			}else{
				for(int j=i;j<i+5;j++){
					num += defalutImageSum.get(j);
				}
			}			
		}			
		return list;
	}
	/**
	 * 根据时间分组获取图片
	 * @param userId
	 * @param offset
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getdefaultimagesgroupbytime.do")
	public List<List<Image>> getDefaultImagesGroupByTime(@RequestParam("userId") long userId,
			@RequestParam("offset") long offset,
			@RequestParam("offsetImage") long offsetImage,
			HttpServletRequest request){
		List<Image> imgList = imageService.getImageGroupByTime(userId, offset,offsetImage);
		return handleImagesGroupByTime(imgList);
	}
	
	/**
	 * 将图片按时间分组
	 * @param imgList
	 * @return
	 */
	private List<List<Image>> handleImagesGroupByTime(List<Image> imgList){
		//再对imgList里面的Image，按时间的不同，分别放到不同的List<image>里面
		List<List<Image>> imgGroup = new ArrayList<List<Image>>();
		List<Image> imgInnerList = new ArrayList<Image>();
		Iterator<Image> it = imgList.iterator();
		Timestamp time =null;
		while(it.hasNext()){
			Image image = it.next();
			Timestamp tmpTime=image.getImageDatetime();//获取图片时间
			if(time==null||time.equals(tmpTime)){//如果是第一次循环，直接加进链表，或者，和上一次循环得到的时间比较，如果相等，添加
				imgInnerList.add(image);
				time=tmpTime; 
			}else{//如果和上一次得到的时间不相等，则把list添加到总imgGroup里面
				imgGroup.add(imgInnerList);
				imgInnerList= new ArrayList<Image>();//指向一块新的空间
				imgInnerList.add(image);//加入
				time = tmpTime;//重新为null
			}
		}
		imgGroup.add(imgInnerList);
		return imgGroup;
	}
	/**
	 * 选出所有的相册名称
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getimagealbum.do")
	public List<String> getImageAlbum(HttpServletRequest request){
		long userId = (long)request.getSession().getAttribute("user_id");
		List<String> l = imageService.getImageAlbum(userId);
		return l;
	}
	
	/**
	 * 上传图片
	 * @param images
	 * @param imageAlbum
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="uploadimages.do",method=RequestMethod.POST)
	public String uploadImages(@RequestParam("images") MultipartFile[] images,
			@RequestParam("imageAlbum") String imageAlbum,
			HttpServletRequest request) throws IllegalStateException, IOException{
		long userId = (long)request.getSession().getAttribute("user_id");		
		//先获取服务器写个文件tomcat/webapps/billblog-manager-controller
		String userImagesFilePath = request.getSession().getServletContext().getRealPath("userImages");
		//指向文件夹
		File userImagesFile = new File(userImagesFilePath);
		//如果没有，创建
		if(!userImagesFile.exists()){
			userImagesFile.mkdirs();
		}
		//先对图片重命名
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
				//压缩图片的图片名称，压缩
				String compressStr = "billblog"+new Date().getTime()+""+i;
				//实际图片的图片名称,原图
				String prefixStr =compressStr +"big";
				//合并名称
				//原图
				String imageName = prefixStr+"."+suffixStr;
				//压缩图
				String compImageName = compressStr+"."+suffixStr;
				//全路径，包括文件夹和文件名
				String imagePathAndName = userImagesFilePath+File.separator+imageName;
				//指向文件图片
				File imageFile = new File(imagePathAndName);
				//复制原图
				images[i].transferTo(imageFile);
				//再把原图进行压缩
				CompressImg compressImg = new CompressImg();
				//参数依次为：原图所在目录，压缩图所在目录，原图名称，压缩图名称，压缩图宽，压缩图高，是否按比例压缩
				compressImg.compressPic(userImagesFilePath, userImagesFilePath, imageName, compImageName, 200, 200, false);
				//获取相对路径存入数据库
				String relativePath = request.getContextPath()+File.separator+"userImages"+File.separator+compImageName;
				//构建Image对象
				Image image = new Image();
				image.setImageAlbum(imageAlbum);
				image.setImageDatetime(new Timestamp(new Date().getTime()));
				image.setUserId(userId);
				image.setImageState((byte)0);
				image.setImagePath(relativePath);
				//插入数据库
				imageService.insertImage(image);
			}else{
				throw new ImageFormatException("上传的图片格式有误！");
			}
		}
		return "redirect:tophotopage.do?userId="+userId;//重定向到相册页面
	}
	
	/**
	 * 选出每组的最新一张图片，作为封面
	 * @param userId
	 * @return
	 */
	@RequestMapping("selectfirstimgbygroup.do")
	@ResponseBody
	public List<Image> selectFirstImgByGroup(@RequestParam("userId") long userId){
		return imageService.selectFirstImgByGroup(userId);		 
	}
	
	/**
	 * 根据相册名称获取相片
	 * @param userId
	 * @param index
	 * @param pageBegin 分组数的起始:0、5、10、15.....
	 * @param imgBegin 图片数的起始：不定，由前面页数展现了多少图片决定
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getimagesbyalbum.do")
	public List<Object> getImagesByAlbum(@RequestParam("userId") long userId,
			@RequestParam("index") int index,
			@RequestParam("imgBegin") int imgBegin,
			@RequestParam("pageBegin") int pageBegin){
		List<Image> imgList = imageService.selectFirstImgByGroup(userId);
		String album = null;
		//根据index，获取相册名称
		for(int i=0;i<imgList.size();i++){
			if(index==i){
				album = imgList.get(index).getImageAlbum();
			}
		}
		//总图片数
		int sum = imageService.selectGroupByTimeAndAlbum(userId, album, pageBegin);
		//获取的图片
		List<Image> needImgList = imageService.selectByAlbumName(userId, album, imgBegin, sum);
		//处理后返回
		List<List<Image>> innerList =  handleImagesGroupByTime(needImgList);
		//根据相册名称，获取图片分组数
		List<Integer> sumList = imageService.countAlbumImageGroupSum(userId, album);
		//分页
		List<Integer> dividePageList = dividePage(sumList);
		//构造
		List<Object> objList = new ArrayList<Object>();
		objList.add(innerList);
		objList.add(dividePageList);
		return objList;
	}
	
	/**
	 * 逻辑删除图片
	 * @param imageId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteimage.do",method=RequestMethod.POST)
	public String[] deleteImage(@RequestParam("imageId")long imageId,HttpServletRequest request){
		long userId = (long)request.getSession().getAttribute("user_id");
		int res = imageService.deleteImage(userId, imageId);
		if(res == 0)
			return null;
		return new String[]{};
	}
	
	/**
	 * 解析微博图片的路径，并且把他们相关信息放进image表中，这只是一个在调试中使用的方法，正式发布之后不会被使用。
	 * @return
	 */
	public String resolveWeiboImagePath(){
		imageService.insertImageFromWeibo();
		return "photo";
	}
}
