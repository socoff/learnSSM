package com.example.demo.config;

import javax.annotation.Resource;

import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.service.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;


public class MyShiroRealm extends AuthorizingRealm{
    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User)principals.getPrimaryPrincipal();
        //authorizationInfo.addRole();
        //authorizationInfo.addStringPermission(p.getPermission());
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()...");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println("username is " + username);
        //System.out.println("username is " + username + ", password is " + (String)token.getCredentials());
        UserInfo userInfo = userInfoService.getUserInfoByUserName(username);
        // UserInfo userInfo = userInfoService.getUserInfoByUid(1);
        if(userInfo == null){
            System.out.println("cannot find userInfo");
            return null;
        }

        // Subject subject = SecurityUtils.getSubject();
        // System.out.println("subject.getSession().getTimeout() is " + subject.getSession().getTimeout());
        // subject.getSession().setTimeout(600 * 1000); // 10分钟，测试用，session超时此处设置才有效
        // System.out.println("subject.getSession().getTimeout() is " + subject.getSession().getTimeout());
        
        System.out.println("----->>userInfo:\n" + userInfo);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.credentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}