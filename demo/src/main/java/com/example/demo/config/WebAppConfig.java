package com.example.demo.config;

import com.example.demo.interceptor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebAppConfig extends WebMvcConfigurationSupport{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 拦截器
        //registry.addInterceptor(new InterceptorConfig());
    }
}