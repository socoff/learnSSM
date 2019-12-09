package com.example.demo.service;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo getUserInfoByUserName(final String userName)
    {
        return userInfoDao.getUserInfoByUserName(userName);
    }
    public UserInfo getUserInfoByUid(final Integer uid)
    {
        return userInfoDao.getUserInfoByUid(uid);
    }

}