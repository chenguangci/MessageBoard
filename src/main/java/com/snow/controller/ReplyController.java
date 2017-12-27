package com.snow.controller;

import com.snow.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class ReplyController {
    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @RequestMapping("/index/insertReply")
    @ResponseBody
    public ModelMap insertReply(@RequestParam(value = "id")Integer id,@RequestParam(value = "userId")String userId,@RequestParam(value = "context")String context) {
        ModelMap modelMap = new ModelMap();
        if (replyService.insertReply(id, userId, context) == 1) {
            modelMap.put("msg","评论成功");
        } else {
            modelMap.put("msg","评论失败");
        }
        return modelMap;
    }

    @RequestMapping("/index/deleteReply")
    @ResponseBody
    public ModelMap deleteReply(@RequestParam(value = "userId")String userId,@RequestParam(value = "messageId")Integer messageId) {
        ModelMap modelMap = new ModelMap();
        if (replyService.deleteReply(userId, messageId) == 1) {
            modelMap.put("msg","删除成功");
        } else {
            modelMap.put("msg","删除失败");
        }
        return modelMap;
    }
}
