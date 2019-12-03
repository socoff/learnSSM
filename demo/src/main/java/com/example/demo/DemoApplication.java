package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// pom.xml中添加了mybatis依赖项，但是又没有配置datasource等信息，
// 可以增加(exclude = {DataSourceAutoConfiguration.class})来避免运行出错
@SpringBootApplication
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
