package com.example.demo;

import java.io.IOException;
import java.io.InputStream;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class MybatisTest {

    @Autowired
    UserService userService;

    public static void main(String[] args) throws IOException {
        System.out.println("main func");
        
 

        // String resource = "mybatis-config.xml";
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // // 构建sqlSessionFactory
        // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // // 获取sqlSession
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        // System.out.println("try to invoke sqlSession function");
        // try
        // {
        //     // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
        //     // 第二个参数：指定传入sql的参数：这里是用户id
        //     User user = sqlSession.selectOne("MyMapper.selectUser", 1);
        //     System.out.println(user);
        // }
        // finally
        // {
        //     sqlSession.close();
        // }

        System.out.println("test!");
    }
}