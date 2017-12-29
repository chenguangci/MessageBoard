package com.snow.controller;
/**
 * 拦截器
 */
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class AllInterceptor implements WebRequestInterceptor {
    public void preHandle(WebRequest webRequest) throws Exception {

    }

    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

    }

    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
