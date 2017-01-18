package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Weibo {
    private Long weiboId;

    private Long userId;

    private String weiboContent;

    private Timestamp weiboPublishtime;

    private Byte weiboState;

    private String weiboImage;

    public Long getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Long weiboId) {
        this.weiboId = weiboId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWeiboContent() {
        return weiboContent;
    }

    public void setWeiboContent(String weiboContent) {
        this.weiboContent = weiboContent == null ? null : weiboContent.trim();
    }

    public Timestamp getWeiboPublishtime() {
        return weiboPublishtime;
    }

    public void setWeiboPublishtime(Timestamp weiboPublishtime) {
        this.weiboPublishtime = weiboPublishtime;
    }

    public Byte getWeiboState() {
        return weiboState;
    }

    public void setWeiboState(Byte weiboState) {
        this.weiboState = weiboState;
    }

    public String getWeiboImage() {
        return weiboImage;
    }

    public void setWeiboImage(String weiboImage) {
        this.weiboImage = weiboImage == null ? null : weiboImage.trim();
    }
}