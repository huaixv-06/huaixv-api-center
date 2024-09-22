package com.huaixv06.apicenter.utils;


import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptUtil {
    public static void main(String[] args) {
        // 加密
        String encPwd1 = encyptPwd("jasypt", "root");
        // 加密
        String encPwd2 = encyptPwd("jasypt", "123456");
        System.out.println(encPwd1);
        System.out.println(encPwd2);
    }
    /**
     * 加密方法
     * @param password jasypt所需要的加密密码配置
     * @param value    需要加密的密码
     */
    public static String encyptPwd(String password, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String result = encryptor.encrypt(value);
        return result;
    }
}
