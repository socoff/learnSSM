package com.example.demo.aspect;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.demo.bean.AdminLog;
import com.example.demo.mapper.AdminLogMapper;

import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component // 声明当前类为配置类,相当于xml文件
@Aspect
public class LogAop {
        /*
    * 创建切入点
    * 创建增强
    *
    * 织入
    * */
    //切入点
    @Pointcut("@annotation(com.example.demo.annotation.LogAnnotation)")
    public void PointCut(){}

    @Autowired
    AdminLogMapper adminLogMapper;

    private static Logger logger = LoggerFactory.getLogger(LogAop.class.getName());

    // 日志 后置增强
    //参数为切入点的名字
    //ProceedingJoinPoint 连接点对象,切点对象,(包含切点附近所有的内容) 目标方法
    @Before("PointCut()")
    // public void logAfter(JoinPoint joinPoint){
    public void logAfter(){

        System.out.println("准备写入日志信息");
        logger.info("准备写入日志信息");
        //获取日志数据
        //创建对象
        AdminLog adminLog = new AdminLog();

        //获取时间
        adminLog.setLogDate(new Date());
        adminLog.setAdminId(0);
        adminLog.setLogContent("这里是一个测试数据");
        adminLog.setLogIp("127.0.0.1");
        adminLog.setLogType("测试");
        adminLogMapper.insertLog(adminLog);

        logger.info("日志信息已写入");



// //-----------------------------------------------------------获取Id----------------
//         //获取Id
//         ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//         //获取Request
//         HttpServletRequest request = requestAttributes.getRequest();
//         //获取Session
//         HttpSession session = request.getSession();
//         //从session中获取数据
//         Admin admin = (Admin) session.getAttribute("admin");

//         if(admin != null){
//             adminLog.setAdminId(admin.getId());
//             //---------------------------------------------------------------获取ip-------------
//             //获取ip
//             adminLog.setLogIp(IPKit.getIpAddrByRequest(request));

// //---------------------------------------------------------------获取方法上注解的内容-------------

//             //获取方法的签名对象
//             MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//             //获取方法对象
//             Method method = signature.getMethod();
//             //获取方法上的注解
//             LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
//             //把注解上的值存入日志表中
//             adminLog.setLogType(annotation.type());
//             adminLog.setLogContent(annotation.content());

// //---------------------------------------------------------------添加到数据库-------------
//             //添加到数据库
//             adminLogDAO.insertAdminLog(adminLog);
//         }else {
//             System.out.println("admin为空");
//         }

    }
}