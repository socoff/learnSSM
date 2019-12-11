package com.example.demo;

import com.example.demo.bean.UserInfo;
import com.example.demo.service.UserInfoService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

// 可以增加@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})来避免运行出错
// MapperScan注解扫描mapper接口，与application.properties中的mybatis.mapper-locations配合使用
//@SpringBootApplication(scanBasePackages = {"com.example.demo.bean", "com.example.demo.interceptor"})
//@ComponentScan(basePackages = {"com.example.demo.bean", "com.example.demo.controller", "com.example.demo.service", "com.example.demo.interceptor"})
//@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.example.demo.bean", "com.example.demo.controller", "com.example.demo.service", "com.example.demo.interceptor", "com.example.demo.config"})
@MapperScan({"com.example.demo.dao", "com.example.demo.mapper"})
@ComponentScan("com.example.demo")
@EnableSwagger2 // 该死的注解！2.9.2的swagger需要将此注解放在application class上，否则会报错，并出现“Unable to infer base url...”对话框
public class DemoApplication /*extends SpringBootServletInitializer*/ {

	// @Bean
    // public InternalResourceViewResolver viewResolver() {
    //     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    //     viewResolver.setPrefix("/WEB-INF/jsp/");
    //     viewResolver.setSuffix(".jsp");
    //     return viewResolver;
	// }

	// @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    //     return application.sources(DemoApplication.class);
    // }
	
	public static void main(final String[] args) {


		SpringApplication.run(DemoApplication.class, args);
	}

}
