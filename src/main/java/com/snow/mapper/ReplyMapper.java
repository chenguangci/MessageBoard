package com.snow.mapper;

import com.snow.entity.Reply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReplyMapper {
    int deleteReply(@Param("userName") String userName, @Param("messageId") Integer messageId, @Param("createTime") String createTime);
    int insertReply(Reply reply);
    List<Reply> selectReple(String id);
}
