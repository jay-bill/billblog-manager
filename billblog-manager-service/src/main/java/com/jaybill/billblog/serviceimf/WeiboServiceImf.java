package com.jaybill.billblog.serviceimf;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.ImageMapper;
import com.jaybill.billblog.mapper.InfoMapper;
import com.jaybill.billblog.mapper.LikeitMapper;
import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.Image;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.Weibo;
import com.jaybill.billblog.service.WeiboService;

@Service
public class WeiboServiceImf implements WeiboService {

	@Autowired
	private WeiboMapper weiboMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private InfoMapper infoMapper;
	/**
	 * 每次最多选出20条
	 */
	@Override
	public List<Weibo> getMineAndMynoticeWeibo(long userId,long offset) {
		List<Weibo> weiboList = weiboMapper.selectMineAndMynoticeWeibo(userId,offset);
		return weiboList;
	}
	/**
	 * 每次最多选出10条
	 */
	@Override
	public List<Weibo> getOneUserWeibo(long userId, long offset) {
		List<Weibo> weiboList = weiboMapper.selectOneUserWeibo(userId,offset);
		return weiboList;
	}
	
	/**
	 * 发微博：如果有图片，则插入image表中
	 */
	@Override
	public void broadcastWeibo(Weibo weibo) {
		//插入微博表中
		weiboMapper.insert(weibo);
		//如果微博中包含图片，插入默认相册
		if(weibo.getWeiboImage()!=null&&weibo.getWeiboImage().length()>0){
			String imagesPaths = weibo.getWeiboImage();
			//分割图片路径
			String [] images = StringUtils.split(imagesPaths, "%%");
			//将userId、image[i]、weiboDatetime获取，包装成Image对象
			for(int i=0;i<images.length;i++){
				Image image = new Image();
				image.setImageAlbum("默认相册");
				image.setImageDatetime(weibo.getWeiboPublishtime());
				image.setImagePath(images[i]);
				image.setImageState((byte)0);//0为默认状态
				image.setUserId(weibo.getUserId());
				//插入image表
				imageMapper.insert(image);
			}			
		}
	}

	/**
	 * 逻辑删除微博
	 */
	@Override
	public int deleteWeibo(long weiboId){
		int res = weiboMapper.deleteWeibo(weiboId, (byte)1);
		return res;
	}
	
	/**
	 * 获取某条微博的内容
	 */
	@Override
	public Weibo getOneWeiboById(long oriWeiboId) {
		Weibo weibo = weiboMapper.selectByPrimaryKey(oriWeiboId);
		return weibo;
	}
}
