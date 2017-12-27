package com.snow.entity;

public class Reply {
    private String context;
    private String createDate;
    private Integer messageId;
    private String userId;

    @Override
    public String toString() {
        return "Reply{" +
                "context='" + context + '\'' +
                ", createDate='" + createDate + '\'' +
                ", messageId=" + messageId +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
}
