package com.huaixv06.apicenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huaixv06.apicenter.annotation.AuthCheck;
import com.huaixv06.apicenter.common.BaseResponse;
import com.huaixv06.apicenter.common.ErrorCode;
import com.huaixv06.apicenter.common.ResultUtils;
import com.huaixv06.apicenter.exception.BusinessException;
import com.huaixv06.apicenter.mapper.UserInterfaceInfoMapper;
import com.huaixv06.apicenter.model.vo.InterfaceInfoVO;
import com.huaixv06.apicenter.service.InterfaceInfoService;
import com.huaixv06.apicentercommon.model.entity.InterfaceInfo;
import com.huaixv06.apicentercommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVO>> getListTopInvokeInterfaceInfo(){
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.getListTopInvokeInterfaceInfo(3);
        Map<Long,List<UserInterfaceInfo>> interfaceInfoidObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",interfaceInfoidObjMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoidObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoVOList);
    }
}
