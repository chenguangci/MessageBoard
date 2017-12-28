package com.snow.entity;

public class Reply {
    private String context;
    private String createDate;
    private Integer messageId;
    private String userName;

    @Override
    public String toString() {
        return "Reply{" +
                "context='" + context + '\'' +
                ", createDate='" + createDate + '\'' +
                ", messageId=" + messageId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
