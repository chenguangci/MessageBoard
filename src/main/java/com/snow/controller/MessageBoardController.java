package com.snow.controller;

import com.snow.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MessageBoardController {
    private final MessageBoardService messageBoardService;
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
    public ModelAndView index(@RequestParam(value = "page", required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView();
        if (total == null) {
            total = messageBoardService.messageNumber(1);
        }
        if (page == null) {
            page = 1;
        }
        int number = 10;
        int limit = number*(page-1);
        modelAndView.addObject("messageBoard",messageBoardService.selectMessageBoard(1,limit,number));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 添加留言
     * @param context 留言内容
     * @param userId 用户id
     * @return 添加结果
     */
    @RequestMapping("/index/insertMessageBoard")
    @ResponseBody
    public ModelMap insertMessageBoard(@RequestParam(value = "context")String context,@RequestParam("userId")String userId) {
        ModelMap modelMap = new ModelMap();
        if (messageBoardService.insertMessageBoard(context, userId) == 1) {
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
     * 审核
     * @param state 状态
     * @param messageId 留言id
     * @return 审核结果
     */
    @RequestMapping(value = "/examine")
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
