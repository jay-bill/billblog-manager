package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class LikeitKey {
    private Long likePeopeleid;

    private Long belikeId;

    private Timestamp likeDatetime;

    public LikeitKey(Long likePeopeleid,Long belikeId,Timestamp likeDatetime){
    	this.likePeopeleid=likePeopeleid;
    	this.belikeId=belikeId;
    	this.likeDatetime=likeDatetime;
    }
    
    public LikeitKey(){}
    
    public Long getLikePeopeleid() {
        return likePeopeleid;
    }

    public void setLikePeopeleid(Long likePeopeleid) {
        this.likePeopeleid = likePeopeleid;
    }

    public Long getBelikeId() {
        return belikeId;
    }

    public void setBelikeId(Long belikeId) {
        this.belikeId = belikeId;
    }

    public Timestamp getLikeDatetime() {
        return likeDatetime;
    }

    public void setLikeDatetime(Timestamp likeDatetime) {
        this.likeDatetime = likeDatetime;
    }
}