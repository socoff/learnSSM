package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 可以增加@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})来避免运行出错
// MapperScan注解扫描mapper接口，与application.properties中的mybatis.mapper-locations配合使用
//@SpringBootApplication(scanBasePackages = {"com.example.demo.bean", "com.example.demo.interceptor"})
//@ComponentScan(basePackages = {"com.example.demo.bean", "com.example.demo.controller", "com.example.demo.service", "com.example.demo.interceptor"})
@SpringBootApplication(scanBasePackages = {"com.example.demo.bean", "com.example.demo.controller", "com.example.demo.service", "com.example.demo.interceptor"})
@MapperScan("com.example.demo.dao")
public class DemoApplication {

	// @Bean
    // public InternalResourceViewResolver viewResolver() {
    //     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    //     viewResolver.setPrefix("/WEB-INF/jsp/");
    //     viewResolver.setSuffix(".jsp");
    //     return viewResolver;
	// }
	
	public static void main(String[] args) {
		System.out.println("let's rock!!!!!!");
		SpringApplication.run(DemoApplication.class, args);
	}

}
