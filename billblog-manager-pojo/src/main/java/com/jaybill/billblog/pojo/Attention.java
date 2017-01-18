package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Attention extends AttentionKey {
    private Timestamp attentionDatetime;

    public Timestamp getAttentionDatetime() {
        return attentionDatetime;
    }

    public void setAttentionDatetime(Timestamp attentionDatetime) {
        this.attentionDatetime = attentionDatetime;
    }
}