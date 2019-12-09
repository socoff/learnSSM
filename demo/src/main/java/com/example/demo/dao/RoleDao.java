package com.example.demo.dao;

import com.example.demo.bean.Role;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    Role getRoleById(@Param("id") Integer id);
}