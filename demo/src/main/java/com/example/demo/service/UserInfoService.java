package com.example.demo.service;

import java.security.SecureRandom;
import java.util.Base64;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;
import com.example.demo.mapper.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    PasswordService passwordService;

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoByUserName(final String userName)
    {
        return userInfoDao.getUserInfoByUserName(userName);
    }
    public UserInfo getUserInfoByUid(final Integer uid)
    {
        return userInfoDao.getUserInfoByUid(uid);
    }

    public void insertUser(UserInfo userInfo)
    {
        String salt = genSalt(16);
        userInfo.setSalt(salt);
        String passwd = passwordService.encryptPassword(userInfo.getPassword(), userInfo.credentialsSalt());
        userInfo.setPassword(passwd);
        userInfoDao.insertUser(userInfo);
        System.out.println("insert userInfo\n" + userInfo);
    }

    public String genSalt(int length)
    {
        Base64.Encoder encoder = Base64.getEncoder();
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[length];
        random.nextBytes(bytes);
        String salt = encoder.encodeToString(bytes).substring(0, length);
        // System.out.println("salt:" + salt);
        // System.out.println("bytes:" + Arrays.toString(bytes));

        return salt;
    }

}