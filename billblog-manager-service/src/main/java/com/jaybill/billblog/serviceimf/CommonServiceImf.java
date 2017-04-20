package com.jaybill.billblog.serviceimf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jaybill.billblog.mapper.AttentionMapper;
import com.jaybill.billblog.mapper.ImageMapper;
import com.jaybill.billblog.mapper.InfoMapper;
import com.jaybill.billblog.mapper.SharecountMapper;
import com.jaybill.billblog.mapper.UserMapper;
import com.jaybill.billblog.mapper.UserinfoMapper;
import com.jaybill.billblog.mapper.WeiboMapper;
import com.jaybill.billblog.pojo.Info;
import com.jaybill.billblog.pojo.Sharecount;
import com.jaybill.billblog.pojo.User;
import com.jaybill.billblog.pojo.Userinfo;
import com.jaybill.billblog.service.CommonService;

@Service
public class CommonServiceImf implements CommonService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserinfoMapper infoMapper;
	@Autowired
	private AttentionMapper attentionMapper;
	@Autowired
	private WeiboMapper weiboMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private InfoMapper infoReadMapper;
	@Autowired
	private SharecountMapper shareMapper;
	@Autowired
	private StringRedisTemplate redisTemplate;
	/**
	 *选出用户的账户基本信息
	 */
	@Override
	public User getUserBaseInfo(String userAccount) {
		User userBeSelected = userMapper.selectByUserAccount(userAccount);
		return userBeSelected;
	}

	/**
	 *选出用户的账户基本信息
	 *方法的重载
	 */
	@Override
	public User getUserBaseInfo(long userId) {
//		Object val = redisTemplate.opsForHash().get("userbase"+userId, "userbase"+userId);
//		if(val!=null){
//			return new Gson().fromJson(""+val, User.class);
//		}
		User userBeSelected = userMapper.selectByPrimaryKey(userId);
		//存入redis
//		redisTemplate.opsForHash().put("userbase"+userId, "userbase"+userId, new Gson().toJson(userBeSelected));
		return userBeSelected;
	}
	
	/**
	 * 选出用户的详细信息
	 */
	@Override
	public Userinfo getUserInfo(long userId) {
		Object val = redisTemplate.opsForHash().get("userinfo"+userId, "userinfo"+userId);
		if(val!=null){
			return new Gson().fromJson(""+val, Userinfo.class);
		}
		Userinfo userInfo = infoMapper.selectByPrimaryKey(userId);
		//存入redis
		redisTemplate.opsForHash().put("userinfo"+userId, "userinfo"+userId, new Gson().toJson(userInfo));
		return userInfo;
	}

	/**
	 * 计算粉丝的数目.传入用户的id，查看他的粉丝数
	 * 先去redis中查找，如果值不存在，再到mysql中搜寻
	 */
	@Override
	public int getFansSum(long userId) {
		Object val= redisTemplate.opsForHash().get("fansSum"+userId, "fansSum"+userId);
		if(val!=null){
			return Integer.valueOf(val.toString());
		}		
		int sum = attentionMapper.selectFansSum(userId);
		//存到redis中
		redisTemplate.opsForHash().put("fansSum"+userId, "fansSum"+userId, sum+"");
		return sum;
	}

	/**
	 * 计算关注的人的数目
	 */
	@Override
	public int getBeNoticeSum(long userId) {
		Object val = redisTemplate.opsForHash().get("notiSum"+userId, "notiSum"+userId);
		if(val!=null){
			return Integer.valueOf(val.toString());
		}
		int sum = attentionMapper.selectBenoticedSum(userId);
		//存到redis中
		redisTemplate.opsForHash().put("notiSum"+userId, "notiSum"+userId, sum+"");
		return sum;
	}

	/**
	 * 计算微博的总数
	 */
	@Override
	public int getWeiboSum(long userId) {
		Object val = redisTemplate.opsForHash().get("wbSum"+userId, "wbSum"+userId);
		if(val!=null){
			return Integer.valueOf(val.toString());
		}
		int sum = weiboMapper.selectWeiboSum(userId);
		//存到redis中
		redisTemplate.opsForHash().put("wbSum"+userId, "wbSum"+userId, sum+"");
		return sum;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUserInfo(User user,Userinfo userInfo) {
		infoMapper.updateByPrimaryKey(userInfo);
		userMapper.updateByPrimaryKeySelective(user);
		//更新weibo表中的用户昵称
		weiboMapper.updateNicknameCauseBySaveUpateInfo(user.getUserId(),user.getUserNickname());
		//更新redis缓存
		//存入redis
		redisTemplate.opsForHash().put("userinfo"+user.getUserId(), "userinfo"+user.getUserId(), new Gson().toJson(userInfo));		
	}

	/**
	 * 获取某个用户图片的所有分组的图片数目
	 */
	@Override
	public List<Integer> getDefaultImageGroupSum(long userId) {
		List<Integer> resList = imageMapper.countDefaultImageGroupSum(userId);
		return resList;
	}
	
	/**
	 * 获取未读的通知数目
	 * @param beinfoId
	 * @return
	 */
	public int selectSumNoRead(long beinfoId){
		return infoReadMapper.selectSumNoRead(beinfoId);
	}
	
	/**
	 * 通过被通知者的id获取通知的信息
	 * @param beinfoId
	 * @return
	 */
	public List<Info> selectByBeinfoId(long beinfoId){
		return infoReadMapper.selectByBeinfoId(beinfoId);
	}
	
	/**
	 * 已读后，将通知状态改为1
	 * @param beinfoId
	 * @return
	 */
	public int updateInfoState(long beinfoId){
		return infoReadMapper.updateInfoState(beinfoId);
	}
	
	/**
	 * 计算微博被转发的次数
	 * @param weiboId
	 * @return
	 */
	public int countForwardSum(long weiboId){
		//返回转发总数
		Sharecount s =  shareMapper.selectByPrimaryKey(weiboId);
		if(s!=null){
			return s.getShareCount();
		}
		return 0;
	}
}
