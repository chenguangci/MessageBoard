package com.snow.controller;
/**
 * 用户登陆，注册模块
 */
import com.snow.entity.User;
import com.snow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service ;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * 开始页面
     * @return
     */
    @RequestMapping
    public ModelAndView login(){
        ModelAndView model = new ModelAndView();
        model.setViewName("begin");
        return model;
    }

    /**
     * 跳转注册或者登陆页面
     * @return
     */
    @RequestMapping(value = "/operation/{operation}")
    public String toRegister(@PathVariable String operation) {
        if ("register".equals(operation))
            return "register";
        else if ("login".equals(operation))
            return "login";
        else
            return "error";
    }

    /**
     * 注册
     * @param user 注册信息
     * @return 注册结果
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public ModelMap register(User user) {
        ModelMap modelMap = new ModelMap();
        if (service.insertUser(user)==1){
            modelMap.put("msg","注册成功");
        } else {
            modelMap.put("msg","注册失败，可能是确实必要信息或者用户名重复");
        }
        return modelMap;
    }

    /**
     * 登陆判断
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(value = "userName", required = false)String userName,
                              @RequestParam(value = "password", required = false)String password,
                              HttpSession session) {
        ModelAndView model = new ModelAndView();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        List<User> users = service.selectUser(user,0,1);
        if (users.size()>0) {
            session.setAttribute("userName", users.get(0).getUserName());
            model.setViewName("redirect:/index");
        } else {
            model.addObject("msg","用户名或密码错误");
            model.setViewName("login");
        }
        return model;
    }

}
