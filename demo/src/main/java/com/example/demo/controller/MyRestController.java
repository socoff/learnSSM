package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.MyResponse;
import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.form.LoginForm;
import com.example.demo.service.UserInfoService;
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
@RequestMapping("/user")
@Api("用户管理")
// @Transactional(rollbackFor = BusinessException.class)
public class MyRestController extends BaseController{
    
    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

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

    @RequestMapping(value = "/getUserInfo1", method = RequestMethod.GET)
    public UserInfo getUserInfoByUid(String uid) throws Exception
    {
        System.out.println("getUserInfoByUid()...");
        UserInfo userInfo = userInfoService.getUserInfoByUid(1);
        System.out.println(userInfo);
        return userInfo;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编号获取用户信息", notes = "用户数据存放在starter数据库的core_user表中")
    @ApiImplicitParam(paramType = "query", required = true, name = "id", type = "long", value = "用户编号")
    public User getUserInfo(Integer id) throws Exception {
        User user = userService.getUserById(id);
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ApiOperation(value = "获取一组用户列表", notes = "获得id为171-175的用户列表")
    @ApiImplicitParam(paramType = "query", required = false, name = "count", type = "long", value = "用户数目（暂无效）")
    public List<User> getUserList(Integer count) throws Exception {
        List<User> user = new ArrayList<>();
        user.add(userService.getUserById(171));
        user.add(userService.getUserById(172));
        user.add(userService.getUserById(173));
        user.add(userService.getUserById(174));
        return user;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "登录", notes = "固定返回")
    @ApiImplicitParam(paramType = "query", required = true, name = "name", type = "long", value = "用户名")
    public MyResponse handleLogin(LoginForm loginForm)
    {
        System.out.println("MyRestController.handleLogin()...");
        MyResponse myResponse = new MyResponse();
        myResponse.setCode(99);
        myResponse.setRes("name: " + loginForm.getName() + ", password: " + loginForm.getPassword());
        return myResponse;
    }
}