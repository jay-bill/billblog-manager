package com.jaybill.billblog.pojo;

/**
 * 新增点赞总数、是否已点赞两个属性
 * @author jaybill
 *
 */
public class Likeit extends LikeitKey {
	
	private long likeSum;
	
	private int isLike;//0为没点赞，1为已点赞
	
	public long getLikeSum() {
		return likeSum;
	}
	
	public void setLikeSum(long likeSum) {
		this.likeSum = likeSum;
	}
	
	public int getIsLike() {
		return isLike;
	}
	
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	
}
