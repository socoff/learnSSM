package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/jsp")
public class JspController {
    
    @RequestMapping("10")
    public String handleJsp10()
    {
        System.out.println("handleJsp10 is invoked");
        return "/10.jsp";
    }

    @RequestMapping("00")
    public String handleJsp00()
    {
        System.out.println("handleJsp00 is invoked");
        return "/1";
    }
    
}