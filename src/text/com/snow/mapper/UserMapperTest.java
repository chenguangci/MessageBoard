package com.snow.mapper;

import com.snow.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * junit启动是加载spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContent.xml"})
public class UserMapperTest extends TestCase {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testUserNumber() throws Exception {
        System.out.println(userMapper.userNumber(new User()));
    }
    @Test
    public void testSelectUser() throws Exception {
        User user = new User();

        System.out.println(userMapper.selectUser(user,0,1).get(0).getUserName());
    }
    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUserName("light");
        user.setPassword("0002");
        System.out.println(userMapper.insertUser(user));
    }
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println(userMapper.deleteUser("0002"));
    }
    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setUserName("snow");
        user.setPassword("0001");
        System.out.println(userMapper.updateUser("0001",user));
    }

}