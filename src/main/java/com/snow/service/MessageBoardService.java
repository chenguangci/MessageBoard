package com.snow.service;

import com.snow.entity.MessageBoard;
import com.snow.mapper.MessageBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageBoardService {
    private final MessageBoardMapper messageBoardMapper;

    @Autowired
    public MessageBoardService(MessageBoardMapper messageBoardMapper) {
        this.messageBoardMapper = messageBoardMapper;
    }

    /**
     * 查找留言数，用于分页
     *
     * @param state 状态
     * @return 条数
     */
    public int messageNumber(Integer state) {
        return messageBoardMapper.messageNumber(state);
    }

    /**
     * 根据状态查找留言
     *
     * @param state  状态
     * @param limit  第几条
     * @param number 每页几条
     * @return 留言集合
     */
    public List<MessageBoard> selectMessageBoard(Integer state, int limit, int number) {
        return messageBoardMapper.selectMessageBoard(state, limit, number);
    }

    /**
     * 删除指定留言
     *
     * @param id 留言编号
     * @return 删除结果 0/1
     */
    public int deleteMessageBoard(Integer id) {
        return messageBoardMapper.deleteMessageBoard(id);
    }

    /**
     * 审核操作
     * @param state 指定状态
     * @param id 留言id
     * @return 结果 0/1
     */
    public int updateMessageBoard(Integer state, Integer id) {
        return messageBoardMapper.updateMessageBoard(state, id);
    }

    public int insertMessageBoard(String context, String userId) {
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setUserId(userId);
        messageBoard.setContext(context);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        messageBoard.setCreateDate(time);
        return messageBoardMapper.insertMessageBoard(messageBoard);
    }
}
