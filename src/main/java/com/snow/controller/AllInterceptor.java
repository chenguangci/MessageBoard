package com.snow.controller;
/**
 * 拦截器
 */
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String uri = httpServletRequest.getRequestURI();
        System.out.println("请求路径："+uri);
        Integer type = (Integer) session.getAttribute("userType");
        if (session.getAttribute("userName") == null){
            //未登陆，返回首页
            httpServletResponse.sendRedirect("/user");
            return false;
        } else if ((uri.contains("examine")||uri.contains("result")) && (type!=null && type<1)) {
            httpServletResponse.sendRedirect("/error");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
