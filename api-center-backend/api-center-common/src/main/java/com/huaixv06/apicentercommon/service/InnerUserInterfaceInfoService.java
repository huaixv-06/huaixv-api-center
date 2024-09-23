package com.huaixv06.apicentercommon.service;

/**
 * 内部用户接口信息服务
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 获取剩余调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean getLeftNum(long interfaceInfoId, long userId);

}
