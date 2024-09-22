package com.huaixv06.apicenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huaixv06.apicentercommon.model.entity.InterfaceInfo;

/**
* @author 11517
* @description 针对表【interface_info】的数据库操作Service
* @createDate 2024-08-06 17:00:13
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验接口信息
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
