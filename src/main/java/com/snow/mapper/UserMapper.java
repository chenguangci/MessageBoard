package com.snow.mapper;

import com.snow.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int userNumber(User user);
    List<User> selectUser(@Param("user") User user,@Param("limit") int limit, @Param("number") int number);
    int insertUser(User user);
    int deleteUser(String name);
    int updateUser(@Param("oldName")String name,@Param("user") User user);
}
