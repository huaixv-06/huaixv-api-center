package com.huaixv06.apicentercommon.service;

/**
 * 内部请求头服务
 */
public interface InnerHeaderMapService {

    /**
     * 从Redis中查询nonce是否存在（
     */
    boolean checkNonce(String nonce);
}