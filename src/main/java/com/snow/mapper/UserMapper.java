package com.snow.mapper;

import com.snow.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int userNumber(User user);
    List<User> selectUser(@Param("user") User user,@Param("limit") int limit, @Param("number") int number);
    int insertUser(User user);
    int deleteUser(String id);
    int updateUser(@Param("oldId")String id,@Param("user") User user);
}
