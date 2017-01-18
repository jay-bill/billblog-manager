package com.jaybill.billblog.pojo;

import java.sql.Timestamp;

public class Message {
    private Long messageId;

    private Long messagePeopleid;

    private Long bemessagePeopleid;

    private String messageContent;

    private Timestamp messageDatetime;

    private Byte messageState;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getMessagePeopleid() {
        return messagePeopleid;
    }

    public void setMessagePeopleid(Long messagePeopleid) {
        this.messagePeopleid = messagePeopleid;
    }

    public Long getBemessagePeopleid() {
        return bemessagePeopleid;
    }

    public void setBemessagePeopleid(Long bemessagePeopleid) {
        this.bemessagePeopleid = bemessagePeopleid;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Timestamp getMessageDatetime() {
        return messageDatetime;
    }

    public void setMessageDatetime(Timestamp messageDatetime) {
        this.messageDatetime = messageDatetime;
    }

    public Byte getMessageState() {
        return messageState;
    }

    public void setMessageState(Byte messageState) {
        this.messageState = messageState;
    }
}