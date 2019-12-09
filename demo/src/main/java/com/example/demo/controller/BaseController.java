package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;

public abstract class BaseController {
    @Value("My Site")
    private String siteName;
}