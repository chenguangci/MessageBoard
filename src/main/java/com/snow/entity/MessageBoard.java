package com.snow.entity;

import java.util.List;

public class MessageBoard {
    private Integer messageBoardId;
    private String context;
    private String createDate;
    private String userName;
    private Integer state;
    private List<Reply> replies;
    @Override
    public String toString() {
        String reply = "";
        if (replies.size() > 0) {
            StringBuilder str = new StringBuilder();
            for (Reply reply1:replies){
                str.append(reply1).append("  ");
            }
            reply = str.toString();
        }
        return "MessageBoard{" +
                ", context='" + context + '\'' +
                ", createDate=" + createDate +
                ", userName='" + userName + '\'' +
                ", state=" + state +","+reply+
                '}';
    }

    public Integer getMessageBoardId() {
        return messageBoardId;
    }

    public void setMessageBoardId(Integer messageBoardId) {
        this.messageBoardId = messageBoardId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
