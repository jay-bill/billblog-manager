package com.jaybill.billblog.serviceimf;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.jaybill.billblog.mapper.AttentionMapper;
import com.jaybill.billblog.mapper.InfoMapper;
import com.jaybill.billblog.pojo.Attention;
import com.jaybill.billblog.pojo.AttentionKey;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.AttentionService;
/**
 * 关注与被关注
 * @author jaybill
 *
 */
@Service
public class AttentionServiceImf implements AttentionService {

	@Autowired
	private AttentionMapper attMapper;
	@Autowired
	private InfoMapper infoMapper;
	@Autowired
	private StringRedisTemplate redisTemplate;
	/**
	 * 关注
	 */
	@Override
	public int insertAttention(long noticerId, long beNoticedId) {
		//装配bean
		Attention attention = new Attention(noticerId,beNoticedId,new Timestamp(new Date().getTime()));
		int result = attMapper.insert(attention);//插入数据库
		//更新redis缓存的值,关注的人数多了一个，粉丝的人数也多了一个
		//先获取关注的人数
		Object obj = redisTemplate.opsForHash().get("notiSum"+noticerId, "notiSum"+noticerId);
		if(obj!=null){
			int value = Integer.valueOf(obj.toString())+1;
			//关注的人数加一
			redisTemplate.opsForHash().put("notiSum"+noticerId, "notiSum"+noticerId, ""+value);
		}
		//再获取被关注者
		Object obj2 = redisTemplate.opsForHash().get("notiSum"+noticerId, "notiSum"+noticerId);
		if(obj2!=null){
			int value = Integer.valueOf(obj2.toString())+1;
			//粉丝的人数加一
			redisTemplate.opsForHash().put("fansSum"+beNoticedId, "fansSum"+beNoticedId, ""+value);
		}
		
		//通知
		Info info = new Info();
		info.setBeinfoId(beNoticedId);
		info.setInfoId(noticerId);
		info.setInfoState((byte)0);
		info.setInfoTime(new Timestamp(new Date().getTime()));
		info.setInfoContent("0@_@关注了你！");
		infoMapper.insert(info);
		return result;//结果为0，失败，为1成功
	}

	/**
	 * 取消关注
	 */
	@Override
	public int deleteAttention(long noticerId, long beNoticedId) {
		//获取AttentionKey的实例
		AttentionKey key = new AttentionKey(noticerId,beNoticedId);
		//从数据库中删除
		int res = attMapper.deleteByPrimaryKey(key);
		//更新redis缓存的值,关注的人数多了一个，粉丝的人数也多了一个
		//先获取关注的人数
		Object obj = redisTemplate.opsForHash().get("notiSum"+noticerId, "notiSum"+noticerId);
		if(obj!=null){
			int value = Integer.valueOf(obj.toString())-1;
			//关注的人数加一
			redisTemplate.opsForHash().put("notiSum"+noticerId, "notiSum"+noticerId, ""+value);
		}
		//再获取被关注者
		Object obj2 = redisTemplate.opsForHash().get("notiSum"+noticerId, "notiSum"+noticerId);
		if(obj2!=null){
			int value = Integer.valueOf(obj2.toString())-1;
			//粉丝的人数加一
			redisTemplate.opsForHash().put("fansSum"+beNoticedId, "fansSum"+beNoticedId, ""+value);
		}
		if(res==0)
			return 0;
		return 1;
	}

	/**
	 * 获取关注的人的信息
	 */
	@Override
	public List<User> getBeNoticedUser(long userId,long offset) {
		List<User> userList = attMapper.selectNoticeListUser(userId,offset);
		return userList;
	}

	/**
	 * 获取关注的人详细信息
	 */
	@Override
	public List<Userinfo> getBeNoticedUserinfo(long userId,long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取粉丝的基本信息，每次选择5个粉丝
	 */
	@Override
	public List<User> getFansUser(long userId,long offset) {
		List<User> userList = attMapper.selectFansListUser(userId,offset);
		return userList;
	}

	/**
	 * 获取粉丝的详细信息
	 */
	@Override
	public List<Userinfo> getFansUserinfo(long userId,long offset) {
		List<Userinfo> userList = attMapper.selectFansListUserinfo(userId,offset);
		return userList;
	}

	/**
	 * 判断是否已经关注.0为没关注，1为已关注
	 */
	@Override
	public int isAlreadyNoticed(long noticerId, long beNoticedId) {
		//获取AttentionKey的实例
		AttentionKey key = new AttentionKey(noticerId,beNoticedId);
		//获取一行记录
		Attention res = attMapper.selectByPrimaryKey(key);
		//如果获取到的记录为空
		if(res==null)
			return 0;
		return 1;
	}

}
