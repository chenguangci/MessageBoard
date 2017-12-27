package com.snow.mapper;

import com.snow.entity.Reply;

import java.util.List;

public interface ReplyMapper {
    int deleteReply(String userId,Integer messageId);
    int insertReply(Reply reply);
    List<Reply> selectReple(String id);
}
