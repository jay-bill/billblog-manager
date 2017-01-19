package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class User {
    private Long userId;

    private String userAccount;

    private String userPassword;

    private Byte userIdentity; //0普通用户，1会员，2管理员，3博主

    private Byte userState;  //0正常使用，1封号

    private Timestamp userDatetime;
    
    private String userHeadimage;
    
    private String userNickname; //默认使用注册账号
    
    private byte userLevel;  //账号等级，默认0级
    

	public byte getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(byte userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserHeadimage() {
		return userHeadimage;
	}

	public void setUserHeadimage(String userHeadimage) {
		this.userHeadimage = userHeadimage;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Byte getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Byte userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Byte getUserState() {
        return userState;
    }

    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    public Timestamp getUserDatetime() {
        return userDatetime;
    }

    public void setUserDatetime(Timestamp userDatetime) {
        this.userDatetime = userDatetime;
    }
}