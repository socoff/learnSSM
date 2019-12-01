package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserById(final Integer id)
    {
        return userDao.getUserById(id);
    }
}