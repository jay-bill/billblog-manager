package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Collection {
    private Long collectionId;

    private Long collectionPeopleid;

    private Long becollectionId;

    private Timestamp collectionDatetime;

    private Byte collectionState;

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getCollectionPeopleid() {
        return collectionPeopleid;
    }

    public void setCollectionPeopleid(Long collectionPeopleid) {
        this.collectionPeopleid = collectionPeopleid;
    }

    public Long getBecollectionId() {
        return becollectionId;
    }

    public void setBecollectionId(Long becollectionId) {
        this.becollectionId = becollectionId;
    }

    public Timestamp getCollectionDatetime() {
        return collectionDatetime;
    }

    public void setCollectionDatetime(Timestamp collectionDatetime) {
        this.collectionDatetime = collectionDatetime;
    }

    public Byte getCollectionState() {
        return collectionState;
    }

    public void setCollectionState(Byte collectionState) {
        this.collectionState = collectionState;
    }
}