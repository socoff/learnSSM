package com.example.demo.service;

import com.example.demo.bean.Role;
import com.example.demo.dao.RoleDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public Role getRoleById(final Integer id)
    {
        return roleDao.getRoleById(id);
    }
}