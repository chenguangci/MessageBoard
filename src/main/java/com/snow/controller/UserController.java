package com.snow.controller;

import com.snow.entity.User;
import com.snow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * 注册
     * @param user 注册信息
     * @return 注册结果
     */
    @RequestMapping(value = "/register")
    public ModelAndView register(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (service.insertUser(user)==1){
            //TODO 返回登陆页面
            modelAndView.setViewName("login");
        } else {
            //TODO 提示失败
            modelAndView.addObject("error","注册失败，可能是确实必要信息");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

    /**
     * 登陆判断
     * @param userId 用户名
     * @param password 密码
     * @return 结果
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(value = "userId", required = false)String userId,
                              @RequestParam(value = "password", required = false)String password) {
        ModelAndView model = new ModelAndView();
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        List<User> users = service.selectUser(user,0,1);
        if (users.size()>0) {
            model.addObject("userName",users.get(0).getUserName());
            model.setViewName("redirect:/index");
        } else {
            model.addObject("msg","用户名或密码错误");
            model.setViewName("login");
        }
        return model;
    }

}
