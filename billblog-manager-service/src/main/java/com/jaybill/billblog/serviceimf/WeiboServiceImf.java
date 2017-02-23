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
import com.jaybill.billblog.mapper.SharecountMapper;
import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.Image;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.Sharecount;
import com.jaybill.billblog.pojo.Weibo;
import com.jaybill.billblog.service.WeiboService;
import com.jaybill.billblog.time.TimeUtils;

@Service
public class WeiboServiceImf implements WeiboService {

	@Autowired
	private WeiboMapper weiboMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private InfoMapper infoMapper;
	@Autowired
	private SharecountMapper shareMapper;
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
	public void insertBroadcastWeibo(Weibo weibo) {
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
		//如果微博是“转发”的
		if(weibo.getWeiboState()==2){
			//通知被转发者（转发链的上一个）他的微博被转发了
			shareInfo(weibo);
			//更新转发次数的数据库
			updateShareCount(weibo);
		}
	}
	
	/**
	 * 通知被转发者
	 * @param weibo
	 */
	private void shareInfo(Weibo weibo){
		//通知原创者
		Info info = new Info();
		//被通知的用户的微博的id
		long prevWeiboId = Long.parseLong(weibo.getWeiboContent().split("@_@")[1]);
		Weibo prevWeibo = weiboMapper.selectByPrimaryKey(prevWeiboId);
		//如果转发的是自己的微博，直接返回，不插入数据库
		if(weibo.getUserId()==prevWeibo.getUserId())
			return;
		//获取被转发微博的用户id
		long prevUserId=prevWeibo.getUserId();
		//被通知者，即微博被转发的用户
		info.setBeinfoId(prevUserId);
		//被通知的内容
		//先获取微博的id
		//拼装成转发的info
		String shareContent = prevWeibo.getWeiboId()+"@_@"+"转发了你的微博！并说：<br>"+weibo.getWeiboContent().split("@_@")[0];
		//设置内容
		info.setInfoContent(shareContent);
		info.setInfoId(weibo.getUserId());
		info.setInfoState((byte)0);
		info.setInfoTime(new Timestamp(new Date().getTime()));
		//插入到通知表中
		infoMapper.insert(info);
	}

	/**
	 * 更新微博的分享次数，沿着转发链，转发次数+1。比如
	 * 微博1——>微博2——>微博3——>微博4——>微博5
	 * +1    +1     +1     +1      +0
	 * @param weibo 当前转发的微博
	 */
	private void updateShareCount(Weibo weibo){
		//分割当前转发转发的微博内容，获取上一条微博的id
		String [] tmp = weibo.getWeiboContent().split("@_@");
		long weiboId = Long.parseLong(tmp[1]);
		while(weiboId>0){
			Sharecount sc = new Sharecount();
			sc.setWeiboId(weiboId);
			sc.setShareCount(1);
			//更新上一条微博转发的次数
			int res = shareMapper.updateByPrimaryKeySelective(sc);//更新转发条数
			if(res == 0){//如果上一条微博没有在转发次数列表中
				sc.setShareCount(1);
				shareMapper.insert(sc);//新增
			}
			//再根据当前weiboId获取上一条微博内容
			Weibo prevWeibo = weiboMapper.selectByPrimaryKey(weiboId);
			//如果上一条微博prevWeibo也是转发的话
			if(prevWeibo.getWeiboState()==2){
				//weiboId指向上一条的上一条微博
				weiboId = Long.parseLong(prevWeibo.getWeiboContent().split("@_@")[1]);
			}else{
				weiboId = -1;
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
