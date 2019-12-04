package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("restful")
@Api("用户管理")
// @Transactional(rollbackFor = BusinessException.class)
public class SwaggerController {
    
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编号获取用户姓名", notes = "test:只有1和2返回正确")
    @ApiImplicitParam(paramType = "query", required = true, name = "id", type = "long", value = "用户编号")
    public String getUserName(Integer id) {
        if (id == 1) {
            return "张三";
        } else if (id == 2) {
            return "李四";
        } else {
            return "未知";
        }
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编号获取用户信息", notes = "用户数据存放在starter数据库的core_user表中")
    @ApiImplicitParam(paramType = "query", required = true, name = "id", type = "long", value = "用户编号")
    public String getUserInfo(Integer id) throws Exception {
        User user = userService.getUserById(id);
        System.out.println(user);
        
        JSONObject js = new JSONObject();
        js.put("name", user.getName());
        js.put("code", user.getCode());
        js.put("password", user.getPassword());
        //js.put("createTime", user.getCreateTime().toString());
        js.put("orgId", user.getOrgId());
        js.put("state", user.getState());
        js.put("jobType", user.getJobType());
        //js.put("delFlag", user.getDelFlag().toString());
        //js.put("updateTime", user.getUpdateTime().toString());
        return js.toString();
    }
}