package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Image;

public interface ImageMapper {
    int deleteByPrimaryKey(Long imageId);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(Long imageId);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
    
    /**
     * 根据用户id和页数偏移量获取微博
     * @param userId
     * @param offset
     * @return
     */
    List<Image> selectByUserId(long userId,long offset,long sum);
    /**
     *算出每5组的总数
     * @param userId
     * @param offset 分页数，0、5、10、15.。。
     * @return
     */
    List<Integer> selectGroupByTime(long userId,long offset);
    /**
     * 根据穿进去的用户和相册名，按照时间分组，获取每组的数目
     * @param userId
     * @param album
     * @param offset
     * @return
     */
    List<Integer> selectGroupByTimeAndAlbum(long userId,String album,long offset);
    /**
     * 获取图片
     * @param userId
     * @return
     */
	int selectOnlyByUserId(long userId);
	
	/**
	 * 计算图片总数
	 */
	List<Integer> countDefaultImageGroupSum(long userId);
	
	/**
	 * 计算图片总数
	 */
	List<Integer> countAlbumImageGroupSum(long userId,String album);
	/**
	 * 选出所有的相册名称
	 * @param userId
	 * @return
	 */
	List<String> selectImageAlbum(long userId);
	
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
}