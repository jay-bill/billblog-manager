package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Forward {
    private Long forwordId;

    private Long beforwardId;

    private Long forwardPeopleid;

    private String forwardContent;

    private Timestamp forwardDatetime;

    private Byte forwardState;

    public Long getForwordId() {
        return forwordId;
    }

    public void setForwordId(Long forwordId) {
        this.forwordId = forwordId;
    }

    public Long getBeforwardId() {
        return beforwardId;
    }

    public void setBeforwardId(Long beforwardId) {
        this.beforwardId = beforwardId;
    }

    public Long getForwardPeopleid() {
        return forwardPeopleid;
    }

    public void setForwardPeopleid(Long forwardPeopleid) {
        this.forwardPeopleid = forwardPeopleid;
    }

    public String getForwardContent() {
        return forwardContent;
    }

    public void setForwardContent(String forwardContent) {
        this.forwardContent = forwardContent == null ? null : forwardContent.trim();
    }

    public Timestamp getForwardDatetime() {
        return forwardDatetime;
    }

    public void setForwardDatetime(Timestamp forwardDatetime) {
        this.forwardDatetime = forwardDatetime;
    }

    public Byte getForwardState() {
        return forwardState;
    }

    public void setForwardState(Byte forwardState) {
        this.forwardState = forwardState;
    }
}