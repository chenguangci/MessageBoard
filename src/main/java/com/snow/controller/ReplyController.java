package com.snow.controller;
/**
 * 处理评论模块
 */

import com.snow.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/index")
public class ReplyController {
    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    /**
     * 进行评论操作
     * @param id 评论的留言id
     * @param context 评论内容
     * @return 评论结果
     */
    @RequestMapping("/insertReply")
    @ResponseBody
    public ModelMap insertReply(@RequestParam(value = "messageId")Integer id,
                                @RequestParam(value = "context",required = false)String context, HttpSession session) {
        ModelMap modelMap = new ModelMap();
        System.out.println("id值为："+id);
        System.out.println("context值为："+context);
        String userName = (String) session.getAttribute("userName");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        if (replyService.insertReply(id, userName, context, time) == 1) {
            modelMap.put("msg","评论成功");
            modelMap.put("time",time);
            modelMap.put("userName",userName);
        } else {
            modelMap.put("msg","评论失败");
        }
        return modelMap;
    }

    /**
     * 留言板主人删除评论
     * @param userName 评论人
     * @param messageId 留言的ID
     * @param createTime 评论时间
     * @return 删除结果
     */
    @RequestMapping("/deleteReply")
    @ResponseBody
    public ModelMap deleteReply(@RequestParam(value = "userName")String userName,@RequestParam(value = "messageId")Integer messageId,
                                @RequestParam(value = "createTime")String createTime) {
        ModelMap modelMap = new ModelMap();
        if (replyService.deleteReply(userName, messageId, createTime) == 1) {
            modelMap.put("msg","删除成功");
        } else {
            modelMap.put("msg","删除失败");
        }
        return modelMap;
    }
}
