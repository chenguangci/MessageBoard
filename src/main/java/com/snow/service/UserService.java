package com.snow.service;

import com.snow.entity.User;
import com.snow.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int userNumber(User user){
        return userMapper.userNumber(user);
    }
    public List<User> selectUser(User user,int limit,int num){
        return userMapper.selectUser(user,limit,num);
    }
    public int updateUser(String oldId, User user){
        return userMapper.updateUser(oldId,user);
    }
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }
    public int deleteUser(String id){
        return userMapper.deleteUser(id);
    }
}
