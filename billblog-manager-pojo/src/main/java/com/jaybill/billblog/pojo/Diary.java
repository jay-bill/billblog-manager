package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Diary {
    private Long diaryId;

    private Long diaryPeopleid;

    private Timestamp diaryDatetime;

    private Byte diaryState;

    private String diaryContent;

    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
    }

    public Long getDiaryPeopleid() {
        return diaryPeopleid;
    }

    public void setDiaryPeopleid(Long diaryPeopleid) {
        this.diaryPeopleid = diaryPeopleid;
    }

    public Timestamp getDiaryDatetime() {
        return diaryDatetime;
    }

    public void setDiaryDatetime(Timestamp diaryDatetime) {
        this.diaryDatetime = diaryDatetime;
    }

    public Byte getDiaryState() {
        return diaryState;
    }

    public void setDiaryState(Byte diaryState) {
        this.diaryState = diaryState;
    }

    public String getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(String diaryContent) {
        this.diaryContent = diaryContent == null ? null : diaryContent.trim();
    }
}