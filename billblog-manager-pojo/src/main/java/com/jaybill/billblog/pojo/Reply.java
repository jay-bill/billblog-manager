package com.jaybill.billblog.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Reply {
    private Long replyId;

    private Long bereplyId;
    
    private Long weiboId;

    private Long commentId;

    private Long replyUserid;

    private String replyContent;

    private Timestamp replyTime;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Long weiboId) {
        this.weiboId = weiboId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReplyUserid() {
        return replyUserid;
    }

    public void setReplyUserid(Long replyUserid) {
        this.replyUserid = replyUserid;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
    }

	public Long getBereplyId() {
		return bereplyId;
	}

	public void setBereplyId(Long bereplyId) {
		this.bereplyId = bereplyId;
	}
    
}