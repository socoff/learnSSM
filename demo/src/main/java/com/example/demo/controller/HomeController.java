package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @Autowired
    UserService userService;
    
    @RequestMapping("/id/{id}")
    public String Index_0(@PathVariable Integer id)
    {
        User user = userService.getUserById(id);
        String str = "user name is: " + user.getName();
        System.out.println(str);
        return str;
    }

    @RequestMapping("/Rest1")
    public String rest1() throws Exception
    {
        JSONObject js = new JSONObject();
        js.put("name", "Tom");
        js.put("age", 19);
        return js.toJSONString();
    }

}