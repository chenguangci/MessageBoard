package com.snow.service;

import com.snow.entity.Reply;
import com.snow.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "reply")
public class ReplyService {

    private final ReplyMapper replyMapper ;

    @Autowired

    public ReplyService(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    /**
     * 插入评论
     * @param id 留言的主键
     * @param context 评论内容
     * @return 结果 0/1
     */
    public int insertReply(Integer id, String userName, String context, String time) {
        Reply reply = new Reply();
        reply.setCreateDate(time);
        reply.setContext(context);
        reply.setMessageId(id);
        reply.setUserName(userName);
        return replyMapper.insertReply(reply);
    }

    /**
     * 删除评论
     * @param userName 评论用户的id
     * @param messageId 留言的id
     * @return 返回结果 0/1
     */
    public int deleteReply(String userName, Integer messageId, String createTime) {
        return replyMapper.deleteReply(userName, messageId, createTime);
    }
}
