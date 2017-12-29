package com.snow.controller;

import com.snow.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class MessageBoardController {
    private final MessageBoardService messageBoardService;
    //每页显示条数
    private static final int number = 10;
    private static Integer total;

    @Autowired
    public MessageBoardController(MessageBoardService messageBoardService) {
        this.messageBoardService = messageBoardService;
    }

    /**
     * 显示留言板首页数据
     * @param page 页数
     * @return 留言详情集合
     */
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "page", required = false) Integer page, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (total == null) {
            total = messageBoardService.messageNumber(1);
        }
        if (page == null) {
            page = 1;
            modelAndView.addObject("userName", session.getAttribute("userName"));
        }
        int limit = number*(page-1);
        modelAndView.addObject("messageBoard",messageBoardService.selectMessageBoard(1,limit,number));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 添加留言
     * @param context 留言内容
     * @param userName 用户id
     * @return 添加结果
     */
    @RequestMapping("/index/insertMessageBoard")
    @ResponseBody
    public ModelMap insertMessageBoard(@RequestParam(value = "context")String context,@RequestParam("userName")String userName) {
        ModelMap modelMap = new ModelMap();
        if (messageBoardService.insertMessageBoard(context, userName) == 1) {
            modelMap.put("msg","发布成功，等待管理员审核");
        } else {
            modelMap.put("msg","发布失败");
        }
        return modelMap;
    }

    /**
     * 删除留言
     * @param messageId 留言的id
     * @return 删除结果
     */
    @RequestMapping("/index/deleteMessageBoard")
    @ResponseBody
    public ModelMap delete(@RequestParam(value = "messageId")Integer messageId) {
        ModelMap modelMap = new ModelMap();
        if (messageBoardService.deleteMessageBoard(messageId) == 1) {
            modelMap.put("msg","删除成功");
        } else {
            modelMap.put("msg","删除失败");
        }
        return modelMap;
    }

    /**
     * 跳转到审核页面
     * @return
     */
    @RequestMapping(value = "/examine")
    public ModelAndView toExamine() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("messageBoard",messageBoardService.selectMessageBoard(0,0,Integer.MAX_VALUE));
        modelAndView.setViewName("examine");
        return modelAndView;
    }

    /**
     * 审核
     * @param state 状态
     * @param messageId 留言id
     * @return 审核结果
     */
    @RequestMapping(value = "/result")
    @ResponseBody
    public ModelMap examine(@RequestParam(value = "state") Integer state, @RequestParam(value = "messageId")Integer messageId) {
        ModelMap modelMap = new ModelMap();
        if (messageBoardService.updateMessageBoard(state, messageId) == 1) {
            modelMap.put("msg","操作成功");
        } else {
            modelMap.put("msg","操作失败");
        }
        return modelMap;
    }
}
