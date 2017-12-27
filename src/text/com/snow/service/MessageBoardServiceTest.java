package com.snow.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContent.xml"})
public class MessageBoardServiceTest extends TestCase {
    @Resource
    private MessageBoardService service;
    @Test
    public void testMessageNumber() throws Exception {

    }
    @Test
    public void testSelectMessageBoard() throws Exception {
        System.out.println(service.selectMessageBoard(1,0,10));
    }
    @Test
    public void testDeleteMessageBoard() throws Exception {
        System.out.println(service.deleteMessageBoard(2));
    }
    @Test
    public void testUpdateMessageBoard() throws Exception {
        System.out.println(service.updateMessageBoard(1,1));
    }
    @Test
    public void testInsertMessageBoard() throws Exception {
        System.out.println(service.insertMessageBoard("来自陈会长的吐槽","0001"));
    }

}