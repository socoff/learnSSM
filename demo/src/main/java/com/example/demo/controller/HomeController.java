package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.LogAnnotation;
import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@Controller
public class HomeController extends BaseController {
    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/login2", method = { RequestMethod.POST, RequestMethod.GET })
    public String helloHtml(HashMap<String, Object> map) {
        System.out.println("helloHtml is invoked");
        map.put("hello", "请登录");
        Date date = new Date();
        map.put("time", date);
        return "/0.html";
    }

    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
    @LogAnnotation(content = "用户登录", type = "login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        System.out.println(request.getHeader("User-Agent"));
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        System.out.println("finish HomeController.login()");
        map.put("msg", msg);
        return "/login";
    }

    @RequestMapping("/403")
    public String handle403() {
        return "/error403";
    }

    @RequestMapping("404")
    public String handleError404() {
        System.out.println("goto page 404");
        return "error404";
    }

    @RequestMapping({ "/hi", "welcome" })
    public String handleLogedin() {
        return "/2";
    }

    @RequestMapping("/")
    public String index(Model model, Map<String, Object> map) {
        //从shiro的session中取activeUser
        System.out.println("===============================================");
        
        // 处理mvc请求时，可以通过SecurityUtils.getSubject().getPrincipal()获取调用者的身份信息，进行差别化的处理
        Subject subject = SecurityUtils.getSubject();
        String sessionId = (String)subject.getSession().getId();
        System.out.println("sessionId is: "  + sessionId);
        UserInfo userInfo =     (UserInfo) subject.getPrincipal();
        
        if(userInfo == null)
        {
            System.out.println("userInfo is null");
            map.put("result", "陌生人");
            subject.logout();
        }
        else
        {
            System.out.println("userInfo:\n" + userInfo);
            //通过model传到页面
            model.addAttribute("adminUser", userInfo);
            map.put("result", userInfo.getName());
        }
        return "/2";
    }


    // @RequestMapping("/id/{id}")
    // public String Index_0(@PathVariable Integer id)
    // {
    // User user = userService.getUserById(id);
    // String str = "user name is: " + user.getName();
    // System.out.println(str);
    // return str;
    // }

    // @RequestMapping("/Rest1")
    // public String rest1() throws Exception
    // {
    // JSONObject js = new JSONObject();
    // js.put("name", "Tom");
    // js.put("age", 19);
    // return js.toJSONString();
    // }

}