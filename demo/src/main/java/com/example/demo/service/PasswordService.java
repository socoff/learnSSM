package com.example.demo.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "passwordService")
public class PasswordService {

    @Value(value = "${shiro.credentials.hashAlgorithmName}")
    private String algorithmName = "md5";
    @Value(value = "${shiro.credentials.hashIterations}")
    private int hashIterations = 2;

    public String encryptPassword(String passwd, String salt) {
        System.out.println("algorithmName is: " + algorithmName);
        System.out.println("hashIterations is: " + hashIterations);
        String newPassword = new SimpleHash(algorithmName, passwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
        System.out.println("final password is: " + newPassword);
        return newPassword;
    }

}