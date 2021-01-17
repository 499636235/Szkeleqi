package com.suzhoukeleqi.test;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * jasypt 加密方法
 */
public class encPassword {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("这里写密钥");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("需要加密的字符串1");
        String password = textEncryptor.encrypt("需要加密的字符串2");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
