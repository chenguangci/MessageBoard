package com.snow.service;

import com.snow.entity.Reply;
import com.snow.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReplyService {
    private final ReplyMapper replyMapper;

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
    public int insertReply(Integer id, String userId, String context) {
        Reply reply = new Reply();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        reply.setCreateDate(time);
        reply.setContext(context);
        reply.setMessageId(id);
        reply.setUserId(userId);
        return replyMapper.insertReply(reply);
    }

    /**
     * 删除评论
     * @param userId 评论用户的id
     * @param messageId 留言的id
     * @return 返回结果 0/1
     */
    public int deleteReply(String userId,Integer messageId) {
        return replyMapper.deleteReply(userId, messageId);
    }
}
