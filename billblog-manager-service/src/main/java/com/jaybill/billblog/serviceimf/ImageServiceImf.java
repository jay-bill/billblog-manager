package com.jaybill.billblog.serviceimf;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.ImageMapper;
import com.jaybill.billblog.mapper.UserMapper;
import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.Image;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Weibo;
import com.jaybill.billblog.service.ImageService;

/**
 * 图片服务
 * @author jaybill
 *
 */
@Service
public class ImageServiceImf implements ImageService {

	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private WeiboMapper weiboMapper;
	/**
	 * 更新头像
	 */
	@Override
	public int updateHeadimage(long userId, String headimage) {
		User record = new User();
		record.setUserHeadimage(headimage);
		record.setUserId(userId);
		int res2 = userMapper.updateUserHeadImage(record);
		int res1 = userMapper.updateForeignHeadImage(record);
		if(res1<=0||res2<=0){
			return 0;
		}
		return 1;
	}

	@Override
	public int insertImage(long userId, String imagePath) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 逻辑删除图片
	 */
	@Override
	public int deleteImage(long userId, long imageId) {
		Image img = imageMapper.selectByPrimaryKey(imageId);
		if(img.getUserId()==userId){//如果是照片的主人执行的删除操作
			int res = imageMapper.deleteImage(imageId);
			return res;
		}
		return 0;
	}

	/**
	 * 调试时用的方法：将图片相关信息从weibo表中导入image表中
	 * @return
	 */
	@Override
	public int insertImageFromWeibo() {
		//先获取所有包含图片的微博
		List<Weibo> weiboList = weiboMapper.selectContainImages();
		Iterator<Weibo> it = weiboList.iterator();
		while(it.hasNext()){
			Weibo weibo = it.next();//取出微博
			String imagesPaths = weibo.getWeiboImage();
			//分割图片路径
			String [] images = StringUtils.split(imagesPaths, "%%");
			//将userId、image[i]、weiboDatetime获取，包装成Image对象
			for(int i=0;i<images.length;i++){
				Image image = new Image();
				image.setImageAlbum("默认相册");
				image.setImageDatetime(weibo.getWeiboPublishtime());
				try {
					image.setImagePath(new String(images[i].getBytes(),"utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				image.setImageState((byte)0);//0为默认状态
				image.setUserId(weibo.getUserId());
				//插入image表
				imageMapper.insert(image);
			}
		}
		return 0;
	}

	/**
	 * 分组获取图片
	 * @return
	 * offset分组的分页数：0、5、10、15
	 * offsetImage图片的分页数：
	 */
	@Override
	public List<Image> getImageGroupByTime(long userId,long offset,long offsetImage) {
		//计算5组图片中总图片数
		List<Integer> intList = imageMapper.selectGroupByTime(userId, offset);
		int sum = 0;
		Iterator<Integer> it = intList.iterator();
		while(it.hasNext()){
			sum = it.next()+sum;//计算总数
		}
		List<Image> imgList = imageMapper.selectByUserId(userId,offsetImage, sum);
		return imgList;
	}

	/**
	 * 选出所有相册名称
	 */
	@Override
	public List<String> getImageAlbum(long userId) {
		return imageMapper.selectImageAlbum(userId);
	}

	/**
	 * 插入相册
	 */
	@Override
	public void insertImage(Image image) {
		imageMapper.insert(image);
	}


	/**
	 * 选出每组的最新一张图片，作为封面
	 * @param userId
	 * @return
	 */
	@Override
	public List<Image> selectFirstImgByGroup(long userId) {
		return imageMapper.selectFirstImgByGroup(userId);		 
	}
	
	/**
	 * 根据相册名称，获取图片
	 * @param userId
	 * @param album
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Image> selectByAlbumName(long userId,String album,int begin,int end){
		return imageMapper.selectByAlbumName(userId, album, begin, end);
	}
	
	/**
	 * 根据用户和相册名，按照时间分组，取出5组，计算5组的总数目
	 * @param userId
	 * @param album
	 * @param offset
	 * @return
	 */
	public int selectGroupByTimeAndAlbum(long userId,String album,long offset){
		List<Integer> list = imageMapper.selectGroupByTimeAndAlbum(userId, album, offset);
		int sum = 0;
		for(int i=0;i<list.size();i++){
			sum+=list.get(i);
		}
		return sum;
	}
	
	/**
	 * 计算相册的图片分组数
	 * @param userId
	 * @param album
	 * @return
	 */
	public List<Integer> countAlbumImageGroupSum(long userId,String album){
		List<Integer> im = imageMapper.countAlbumImageGroupSum(userId, album);
		return im;
	}

	/**
	 * 获取最新六张图片
	 */
	@Override
	public List<Image> selectLastSix(long userId) {
		List<Image> imgList = imageMapper.selectLastSix(userId);
		return imgList;
	}
}
