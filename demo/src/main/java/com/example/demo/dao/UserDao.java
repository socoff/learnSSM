package com.example.demo.dao;

import com.example.demo.bean.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

// DAO是用于定义map接口的
// 接口会被mapper.xml生成的类实现
@Repository
public interface UserDao {
    User getUserById(@Param("id") Integer id);
}