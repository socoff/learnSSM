package com.example.demo.mapper;

import java.util.List;

import com.example.demo.bean.UserInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// 基于注解的mybatis映射，一个mapper接口对应替换xml映射文件和DAO接口文件
public interface UserInfoMapper {
    @Select("select * from user_info")
    // @Results({
    //     @Result(property = "name", column = "name"),
    //     @Result(property = "password", column = "password")
    // })
    List<UserInfo> getAll();
    
    @Select("select * from user_info where username=#{userName}")
    UserInfo getUserInfoByUserName(String userName);

    @Select("select * from user_info where uid=#{uid}")
    UserInfo getUserInfoByUid(Integer uid);

    @Insert("insert into user_info(uid,name,password,salt,state,username) values(#{uid},#{name},#{password},#{salt},#{state},#{userName})")
    void insertUser(UserInfo userInfo);

    @Update("update user_info set username=#{userName},password=#{password},salt=#{salt},state=#{state},name=#{name} where uid=#{uid}")
    void updateUser(UserInfo userInfo);
}