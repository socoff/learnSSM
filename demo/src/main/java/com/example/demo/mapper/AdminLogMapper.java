package com.example.demo.mapper;

import java.util.List;

import com.example.demo.bean.AdminLog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AdminLogMapper {
    @Select("select * from AdminLog")
    List<AdminLog> getAll();

    @Insert("insert into AdminLog(log_date,admin_id,log_content,log_type,log_ip) values(#{logDate},#{adminId},#{logContent},#{logType},#{logIp})")
    void insertLog(AdminLog adminLog);
}