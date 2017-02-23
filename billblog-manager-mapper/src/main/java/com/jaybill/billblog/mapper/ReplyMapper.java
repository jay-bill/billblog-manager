package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Long replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Long replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    /**
     * 获取回复
     * @param weiboId
     * @param commentId
     * @return
     */
	List<Reply> selectById(long weiboId, long commentId);

	/**
	 * 获取回复的id
	 * @param replyUserid
	 * @param str
	 * @return
	 */
	Reply selectReplyId(Long replyUserid);

	/**
	 * 获取回复数目
	 * @param weiboId
	 * @param commentId
	 * @return
	 */
	int selectReplySum(long weiboId, long commentId);
}