package com.snow.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContent.xml"})
public class ReplyServiceTest extends TestCase {
    @Resource
    private ReplyService service;
    @Test
    public void testInsertReply() throws Exception {
        System.out.println(service.insertReply(1,"0002","陈会长说的对"));
    }
    @Test
    public void testDeleteReply() throws Exception {
    }

}