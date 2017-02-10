package com.jaybill.billblog.serviceimf;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.InfoMapper;
import com.jaybill.billblog.mapper.LikeitMapper;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.LikeitKey;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.service.LikeService;

@Service
public class LikeServiceImf implements LikeService {
	
	@Autowired
	private LikeitMapper likeMapper;
	@Autowired
	private InfoMapper infoMapper;
	/**
	 * 点赞
	 */
	@Override
	public int insertLikeWeibo(long likePeopleId, long belikeId,long beinfoId) {
		//创建点赞对象
		LikeitKey record = new LikeitKey(likePeopleId,belikeId,new Timestamp(new Date().getTime()));
		//插入数据库
		int res = likeMapper.insert(record);
		//通知
		if(likePeopleId!=beinfoId){
			Info info = new Info();
			info.setBeinfoId(beinfoId);
			info.setInfoId(likePeopleId);
			info.setInfoContent(belikeId+"@_@"+"赞了你！");
			info.setInfoState((byte)0);
			info.setInfoTime(new Timestamp(new Date().getTime()));
			infoMapper.insert(info);
		}
		return res;
	}

	/**
	 * 判断是否点赞了
	 */
	@Override
	public int selectIsAlreadyLike(long likePeopleId, long belikeId) {
		LikeitKey res = likeMapper.selectLikeWeibo(likePeopleId, belikeId);
		if(res==null)
			return 0;
		return 1;//0没找到，1找到了
	}

	/**
	 * 取消点赞:根据当前用户和被点赞的内容id，删除它
	 */
	@Override
	public int deleteLikeWeibo(long likePeopleId, long belikeId,long beinfoId) {
		int res = likeMapper.deleteTogetherId(likePeopleId,belikeId);
		//取消通知
		infoMapper.deleteByBeinfoidAndInfoIdAndBelikeId(beinfoId,likePeopleId,belikeId+"@_@赞了你！");
		return res;
	}

	/**
	 * 计算点赞总数
	 */
	@Override
	public int getLikeSum(long belikeId) {
		int res = likeMapper.selectLikeSum(belikeId);
		return res;
	}

	/**
	 * 显示点赞的人的基本信息
	 */
	@Override
	public List<User> selectPeopleLiked(long belikeId,long offset) {
		List<User> userList = likeMapper.selectUserLiked(belikeId,offset);
		return userList;
	}

	/**
	 * 获取点赞时间
	 */
	@Override
	public List<Timestamp> selectLikeTime(long belikeId, long offset) {
		List<Timestamp> timeList = likeMapper.selectLikeTime(belikeId,offset);
		return timeList;
	}
}
