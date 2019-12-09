package com.example.demo.dao;

import com.example.demo.bean.UserInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

// DAO是用于定义map接口的
// 接口会被mapper.xml生成的类实现
@Repository
public interface UserInfoDao {
    UserInfo getUserInfoByUserName(@Param("userName") String userName);
    UserInfo getUserInfoByUid(@Param("uid") Integer uid);
}