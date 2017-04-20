package com.jaybill.billblog.pojo;

public class Visits {
    private Long userId;

    private Integer times;

    public Visits(){}
    public Visits(long userId,int times){
    	this.userId = userId;
    	this.times = times;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}