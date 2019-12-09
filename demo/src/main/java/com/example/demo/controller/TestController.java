package com.example.demo.controller;

//import com.example.demo.form;
import com.example.demo.form.LoginForm;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/user")
public class TestController extends BaseController
{

    private String keyBaiduMap = "//api.map.baidu.com/api?v=2.0&ak=0b7ASBceKlUBnIwqVvLOHRqlYtSxyM5I";

    // 缺省跳转，用于处理404错误
    // @RequestMapping("*")
    // public String handle404()
    // {
    //     return "error404";
    // }

    /**
     * 本地访问内容地址 ：http://localhost:8080/hello1
     * @param map
     * @return
     */


    @RequiresPermissions("userInfo:view")//权限管理;
    @RequestMapping("hi")
    public String hi(Model model)
    {
        System.out.println("hi is invoked");
        return "/1";
        // model.addAttribute("hello", "另一种欢迎");
        // Date date = new Date();
        // model.addAttribute("time", date);
        // return "/0";
    }

    @RequestMapping("login000")
    public String handleLogin(/*@ModelAttribute */LoginForm loginForm, HashMap<String, Object> map)
    {
        //model.addAttribute("name", loginForm.getName());
        //model.addAttribute("password", loginForm.getPassword());
        map.put("name", loginForm.getName());
        String str = "redirect:loginResult?name=" + loginForm.getName();
        System.out.println(str);
        return str;
    }

    @RequestMapping("loginResult")
    public String handleLoginResult(@RequestParam("name") String userName, HashMap<String, Object> map)
    {
        System.out.println(userName);
        map.put("name", userName);
        map.put("name", userName);
        map.put("name", userName);
        return "1";
    }
    // public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    // {
    //     ModelAndView mv = new ModelAndView("1");
    //     mv.addObject("name", "solo1");
    //     return mv;
    // }
    // public ModelAndView getParam(HttpServletRequest request, HttpServletResponse response)
    // {
    //     System.out.println("user " + request.getParameter("name") + "'s passowrd is " + request.getParameter("password"));
    //     request.setAttribute("name", "solo");

    //     return new ModelAndView("1");
    // }
    // public ModelAndView getParam(@RequestParam("name") String userName, @RequestParam("password") Integer pwd)
    // {
    //     System.out.println("user " + userName + "'s passowrd is " + (pwd + 1));
    //     return new ModelAndView("1");
    // }
    // // public String button0Clicked(/*@ModelAttribute */LoginForm loginForm, 
    //     HashMap<String, Object> map)
    // {
    //     System.out.println("user " + loginForm.getName() + " is logined");
    //     map.put("name", loginForm.getName());
    //     map.put("password", loginForm.getPassword());
    //     return "/1";
    // }

    @RequestMapping("/vue0")
    public String handleVue01(){
        System.out.println("默认情况...");
        return "/vue_0";
    }

    @RequestMapping("/say/{txt}")
    public String saySomething(@PathVariable String txt, HashMap<String, Object> map)
    {
        System.out.println("say something...");
        map.put("name", txt);
        return "1";
    }

    @RequestMapping("/testForward")
    public String testVoidForward(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("run testForward...");
        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=UTF-8");
        //response.getWriter().print("你好，这是直接响应");
        //request.getRequestDispatcher("/2.html").forward(request, response);
        return "1";
    }

    @RequestMapping("baidu")
    public String handleBaiduMapRequest(HashMap<String, Object> map)
    {
        map.put("key", keyBaiduMap);
        return "baidu_1";
    }

    @RequestMapping("/jump")
    public ModelAndView jump()
    {
        ModelAndView mv = new ModelAndView("redirect:/hi");
        return mv;
    }

    // 注解为ModelAttribute的方法会在RequestMapping方法之前被执行，
    // 多个ModelAttribute的方法执行顺序未知
    // @ModelAttribute
    // public void whatTheFuck2()
    // {
    //     System.out.println("what the fuck #2?"); 
    // }

    @ModelAttribute
    public void whatTheFuck()
    {
        System.out.println("what the fuck?");
    }

    // 上传文件
    @RequestMapping("/upload")
    //@ResponseBody //此注解需关注
    // html提交过来的元素名是picture，而在函数中想使用另外的变量名，这时候就要用到@RequestParam("picture")
    // 上传文件时，要买注解ResponseBody，要么返回指定视图，否则出错，原因在探索中
    // 可以将@Controller换成@RestController，不过需要注意有没有其他的方法返回了html页面，会导致返回的不是页面而是字符串；
    // 最好的方法就是在你所请求的方法上面加一个@ResponseBody即可
    public String upload1(@RequestParam("picture") MultipartFile imgFile, HttpServletRequest request) throws Exception
    {
        System.out.println("uploading file");
        System.out.println(imgFile.getOriginalFilename());
        System.out.println(imgFile.getSize());
        request.setAttribute("name", "文件传输完成");
        return "1";
    }


    @RequestMapping("/upload2")
    //@ResponseBody
    public String upload2(@RequestParam("picture") MultipartFile imgFile, HttpServletRequest request) throws Exception
    {
        System.out.println("***************");
        System.out.println(imgFile.getOriginalFilename());
        System.out.println(imgFile.getSize());
        /*
        //1. 获取上传的目录路径
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);

        //2. 以天为单位，一天创建一个文件夹，保存当天上传的文件
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        //3. 创建目录
        File file = new File(path,date);
        if (!file.exists()){
            // 创建目录或子目录
            file.mkdirs();
        }

        //4. 文件上传
        //4.1 获取原始文件名
        String fileName = imgFile.getOriginalFilename();
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        //4.2 文件上传 【关键代码】
        imgFile.transferTo(new File(file, fileName));

        request.setAttribute("name", "文件传送完成");
        System.out.println("文件已保存至" + fileName);
        */
        return "0";
    }
/*
    @RequestMapping("list")
    public void handleList()
    {

    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder)
    {
        System.out.print("initUser is invoked");
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder)
    {
        System.out.print("initAdmin is invoked");
        binder.setFieldDefaultPrefix("admin.");
    }
*/
}