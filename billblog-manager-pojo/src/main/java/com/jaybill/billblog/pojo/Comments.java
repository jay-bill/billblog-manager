package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Comments {
    private Long commentId;

    private Long becommentId;

    private Long commentReviewerid;

    private String commentContent;

    private Timestamp commentDatetime;

    private Byte comentState;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBecommentId() {
        return becommentId;
    }

    public void setBecommentId(Long becommentId) {
        this.becommentId = becommentId;
    }

    public Long getCommentReviewerid() {
        return commentReviewerid;
    }

    public void setCommentReviewerid(Long commentReviewerid) {
        this.commentReviewerid = commentReviewerid;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Timestamp getCommentDatetime() {
        return commentDatetime;
    }

    public void setCommentDatetime(Timestamp commentDatetime) {
        this.commentDatetime = commentDatetime;
    }

    public Byte getComentState() {
        return comentState;
    }

    public void setComentState(Byte comentState) {
        this.comentState = comentState;
    }
}