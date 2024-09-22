package com.huaixv06.apicenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huaixv06.apicentercommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 11517
* @description 针对表【user_interface_info】的数据库操作Mapper
* @createDate 2024-08-15 01:17:38
* @Entity com.huaixv06.apicenter.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> getListTopInvokeInterfaceInfo(int limit);

}




