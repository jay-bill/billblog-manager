package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Attention extends AttentionKey {
    private Timestamp attentionDatetime;

    public Attention(){}
    public Attention(Long attentionNoticerid,Long attentionBenoticedid,Timestamp attentionDatetime){
    	super(attentionNoticerid,attentionBenoticedid);
    	this.attentionDatetime=attentionDatetime;
    }
    public Timestamp getAttentionDatetime() {
        return attentionDatetime;
    }

    public void setAttentionDatetime(Timestamp attentionDatetime) {
        this.attentionDatetime = attentionDatetime;
    }
}