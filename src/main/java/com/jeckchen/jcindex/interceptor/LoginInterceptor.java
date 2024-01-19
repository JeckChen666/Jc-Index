package com.jeckchen.jcindex.interceptor;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JeckChen
 * @version 1.0.0
 * @className HandlerInterceptor.java
 * @description 登录拦截器
 * @date 2024年01月19日 10:40
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前检测用户是否已登录
        if (!StpUtil.isLogin()) {
            // 用户未登录，重定向到指定页面（这里假设指定页面为登录页）
            response.sendRedirect("/login");
            return false; // 终止请求继续执行
        }
        return true; // 用户已登录，继续执行请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理之后可以进行一些处理
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在请求完成之后可以进行一些处理
    }
}