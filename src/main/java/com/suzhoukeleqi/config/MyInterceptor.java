package com.suzhoukeleqi.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器 (AOP)
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 进入 Controller 之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        System.out.println("=======进入前=======");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

//        if("xiongda".equals(username) && "123456".equals(password)) {
//            return true;
//        }else {
//            return false;
//        }
        return true;
    }

    /**
     * 进入 Controller 之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println("=================进入后===============");
    }

}