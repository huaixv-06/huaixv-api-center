package com.huaixv06.apicenter.service.impl.inner;

import com.huaixv06.apicenter.service.UserInterfaceInfoService;
import com.huaixv06.apicentercommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public boolean getLeftNum(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.getLeftNum(interfaceInfoId, userId);
    }
}
