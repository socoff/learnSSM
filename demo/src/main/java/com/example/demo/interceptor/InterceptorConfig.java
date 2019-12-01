package com.example.demo.interceptor;

import com.example.demo.annotation.Intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 进入controller之前可以按照本方法拦截
 */
public class InterceptorConfig implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    /**
     * 进入controller层之前拦截请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandler is invoked");
        return true;
        /*
        HttpSession session = httpServletRequest.getSession();
        // 判断是否访问springmvc方法
        if(o.getClass().isAssignableFrom(HandlerMethod.class)) {
            // 先获取请求类的类型
            Class<?> clazz = ((HandlerMethod) o).getBeanType();
            // 类头是否标注该注解
            Intercept interceptType = clazz.getAnnotation(Intercept.class);
            if (interceptType != null){
                // 进入判断
                return handle(interceptType, session, httpServletResponse);
            }
            // 如果没有类头注解，查看方法注解
            Intercept intercept = ((HandlerMethod)o).getMethodAnnotation(Intercept.class);
            if (intercept != null){
                return handle(intercept, session, httpServletResponse);
            }
        }
        sendErrorMessage(httpServletResponse, "无权限");
        return false;
        */
    }


    private boolean handle(Intercept intercept, HttpSession session, HttpServletResponse httpServletResponse) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("---------------视图渲染之后的操作-------------------------0");
    }

    private void sendErrorMessage(HttpServletResponse response, String message) throws Exception {

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(message);
        out.close();
    }
}
