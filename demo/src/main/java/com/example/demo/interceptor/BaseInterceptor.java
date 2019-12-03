package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义拦截器
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final Logger LOGGE = LoggerFactory.getLogger(BaseInterceptor.class);
    private static final String USER_AGENT = "user-agent";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();

        System.out.println("BaseInterceptor.preHandle is invoked");
        System.out.println("context path: " + request.getContextPath());

        LOGGE.info("UserAgent: {}", request.getHeader(USER_AGENT));

        // if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") 
        //         && !uri.startsWith("/admin/css") && !uri.startsWith("/admin/images")
        //         && !uri.startsWith("/admin/js") && !uri.startsWith("/admin/plugins")
        //         && !uri.startsWith("/admin/editormd")) {
        //     response.sendRedirect(request.getContextPath() + "/admin/login");
        //     return false;
        // }

        return true;
    }

    // @Override
    // public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    //     System.out.println("postHandle is invoked");
    // }

    // @Override
    // public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    //     System.out.println("afterCompletion is invoked");
    // }
}
