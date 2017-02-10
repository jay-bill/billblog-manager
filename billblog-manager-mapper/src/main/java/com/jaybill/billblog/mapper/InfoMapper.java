package com.jaybill.billblog.mapper;

import java.util.List;

import com.jaybill.billblog.pojo.Info;

public interface InfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
    
    /**
     * 根据被通知者用户id， 判断是否有未读消息
     * @param beinfoId
     * @return
     */
    int selectSumNoRead(long beinfoId);
    /**
     * 通过被通知者的id获取通知的信息
     * @param beinfoId
     * @return
     */
    List<Info> selectByBeinfoId(long beinfoId);
    
    /**
     * 已读后，将通知状态改为1
     * @return
     */
    int updateInfoState(long beinfoId);

    /**
     * 删除
     * @param beinfoId
     * @param likePeopleId
     * @param belikeId
     */
	void deleteByBeinfoidAndInfoIdAndBelikeId(long beinfoId, long likePeopleId, String content);
}