package com.snow.mapper;

import com.snow.entity.MessageBoard;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface MessageBoardMapper {
    int messageNumber(Integer state);
    List<MessageBoard> selectMessageBoard(@Param("state") Integer state, @Param("limit") int limit, @Param("number") int number);
    int insertMessageBoard(MessageBoard messageBoard);
    int deleteMessageBoard(Integer id);
    int updateMessageBoard(@Param("state") Integer state, @Param("id") Integer id);
}
