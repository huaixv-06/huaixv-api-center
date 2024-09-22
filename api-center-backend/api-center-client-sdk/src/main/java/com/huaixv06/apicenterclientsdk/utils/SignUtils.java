package com.huaixv06.apicenterclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;


/**
 * 签名工具
 */
public class SignUtils {

    /**
     * 签名算法
     * @param body
     * @param secretKey
     * @return
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        String digestHex = md5.digestHex(content);
        return digestHex;

    }
}
