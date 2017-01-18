package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Userinfo {
    private Long userId;

    private String userNickname;

    private Byte userSex;

    private Timestamp userBirthday;

    private String userSchool;

    private String userPosition;

    private Byte userLovestate;

    private String userSignature;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Timestamp getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Timestamp userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool == null ? null : userSchool.trim();
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition == null ? null : userPosition.trim();
    }

    public Byte getUserLovestate() {
        return userLovestate;
    }

    public void setUserLovestate(Byte userLovestate) {
        this.userLovestate = userLovestate;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }
}