package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Info {
    private Long id;

    private Long beinfoId;

    private Long infoId;

    private String infoContent;

    private Timestamp infoTime;
    
    /**
     * 通知状态：0为未读，1为已读。
     */
    private byte infoState;
    
    public byte getInfoState() {
		return infoState;
	}

	public void setInfoState(byte infoState) {
		this.infoState = infoState;
	}
    
    public Timestamp getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(Timestamp infoTime) {
		this.infoTime = infoTime;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBeinfoId() {
        return beinfoId;
    }

    public void setBeinfoId(Long beinfoId) {
        this.beinfoId = beinfoId;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent == null ? null : infoContent.trim();
    }
}