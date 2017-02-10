package com.jaybill.billblog.pojo;

public class AttentionKey {
    private Long attentionNoticerid;

    private Long attentionBenoticedid;

    public AttentionKey(){}

    public AttentionKey(Long attentionNoticerid,Long attentionBenoticedid){
    	this.attentionBenoticedid = attentionBenoticedid;
    	this.attentionNoticerid = attentionNoticerid;
    }
    
    public Long getAttentionNoticerid() {
        return attentionNoticerid;
    }

    public void setAttentionNoticerid(Long attentionNoticerid) {
        this.attentionNoticerid = attentionNoticerid;
    }

    public Long getAttentionBenoticedid() {
        return attentionBenoticedid;
    }

    public void setAttentionBenoticedid(Long attentionBenoticedid) {
        this.attentionBenoticedid = attentionBenoticedid;
    }
}