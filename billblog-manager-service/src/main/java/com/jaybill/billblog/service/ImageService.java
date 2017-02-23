package com.jaybill.billblog.service;

import java.util.List;

import com.jaybill.billblog.pojo.Image;

/**
 * 图片服务
 * @author jaybill
 *
 */
public interface ImageService {
	
	/**
	 * 更新头像
	 * @param headimage
	 * @return
	 */
	int updateHeadimage(long userId,String headimage);
	
	/**
	 * 上传图片
	 * @param userId
	 * @param imagePath
	 * @return
	 */
	int insertImage(long userId,String imagePath);
	
	/**
	 * 删除图片
	 * @param userId
	 * @param imageId
	 * @return
	 */
	int deleteImage(long userId,long imageId);

	/**
	 * 调试时用的方法：将图片相关信息从weibo表中导入image表中
	 * @return
	 */
	int insertImageFromWeibo();
	
	/**
	 * 分组获取图片
	 * @return
	 */
	List<Image> getImageGroupByTime(long userId,long offset,long offsetImage);
	
	/**
	 * 选出所有的相册名称
	 * @param userId
	 * @return
	 */
	List<String> getImageAlbum(long userId);

	/**
	 * 插入相册
	 * @param image
	 */
	void insertImage(Image image);

	/**
	 * 选出每组的最新一张图片，作为封面
	 * @param userId
	 * @return
	 */
	List<Image> selectFirstImgByGroup(long userId);
	
	/**
	 * 根据相册名称，获取图片
	 * @param userId
	 * @param album
	 * @param begin
	 * @param end
	 * @return
	 */
	List<Image> selectByAlbumName(long userId,String album,int begin,int end);
	
	/**
	 * 根据用户和相册名，按照时间分组，取出5组，计算5组的总数目
	 * @param userId
	 * @param album
	 * @param offset
	 * @return
	 */
	public int selectGroupByTimeAndAlbum(long userId,String album,long offset);
	
	/**
	 * 计算相册的图片分组数
	 * @param userId
	 * @param album
	 * @return
	 */
	public List<Integer> countAlbumImageGroupSum(long userId,String album);

	/**
	 * 获取最新六张图片
	 * @param userId
	 * @return
	 */
	List<Image> selectLastSix(long userId);
}
