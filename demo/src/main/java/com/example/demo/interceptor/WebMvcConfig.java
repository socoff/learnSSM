package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//ApplicationInitializer 
//AbstractAnnotationConfigDispatcherServletInitializer  

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private BaseInterceptor baseInterceptor;

    // @Autowired
    // private InterceptorConfig interceptorConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("WebMvcConfig.addInterceptors() is invoked");
        // registry.addInterceptor(interceptorConfig);
        registry.addInterceptor(baseInterceptor);
        // registry.add(interceptor).excludePathPatterns("/**/*.css", "/**/*.js",
        // "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/*.html",
        // "/**/*.html","/swagger-resources/**");
    }

    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {

    //     registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs?group=restful-api");
    //     registry.addRedirectViewController("/documentation/swagger-resources/configuration/ui",
    //             "/swagger-resources/configuration/ui");
    //     registry.addRedirectViewController("/documentation/swagger-resources/configuration/security",
    //             "/swagger-resources/configuration/security");
    //     registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
    // }

    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     registry.addResourceHandler("/documentation/swagger-ui.html**")
    //             .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
    //     registry.addResourceHandler("/documentation/webjars/**")
    //             .addResourceLocations("classpath:/META-INF/resources/webjars/");
    // }
    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // System.out.println("addResourceHandlers");
    // registry.addResourceHandler("**/swagger-ui.html")
    // .addResourceLocations("classpath:/META-INF/resources/");
    // registry.addResourceHandler("/webjars*")
    // .addResourceLocations("classpath:/META-INF/resources/webjars/");
    // }

}