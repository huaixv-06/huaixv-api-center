package com.huaixv06.apicenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huaixv06.apicenter.common.ErrorCode;
import com.huaixv06.apicenter.exception.BusinessException;
import com.huaixv06.apicenter.exception.ThrowUtils;
import com.huaixv06.apicenter.service.InterfaceInfoService;
import com.huaixv06.apicenter.mapper.InterfaceInfoMapper;
import com.huaixv06.apicentercommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author 11517
* @description 针对表【interface_info】的数据库操作Service实现
* @createDate 2024-08-06 17:00:13
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    /**
     * 校验
     * @param interfaceInfo
     * @param add
     */
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestParams = interfaceInfo.getRequestParams();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        String method = interfaceInfo.getMethod();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name,description,url,requestHeader,responseHeader,method), ErrorCode.PARAMS_ERROR);
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名称过长");
        }
        if (StringUtils.isNotBlank(description) && description.length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口描述过长");
        }
        if (StringUtils.isNotBlank(url) && url.length() > 256) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口地址过长");
        }
        if (StringUtils.isNotBlank(requestParams) && requestParams.length() > 2048) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数过长");
        }
        if (StringUtils.isNotBlank(requestHeader) && requestHeader.length() > 2048) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求头过长");
        }
        if (StringUtils.isNotBlank(responseHeader) && responseHeader.length() > 2048) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "响应头过长");
        }
        if (StringUtils.isNotBlank(method) && method.length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求类型过长");
        }
    }

}




