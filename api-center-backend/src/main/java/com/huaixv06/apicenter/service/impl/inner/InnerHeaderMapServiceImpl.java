package com.huaixv06.apicenter.service.impl.inner;

import com.huaixv06.apicenter.common.ErrorCode;
import com.huaixv06.apicenter.exception.BusinessException;
import com.huaixv06.apicentercommon.service.InnerHeaderMapService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@DubboService
public class InnerHeaderMapServiceImpl implements InnerHeaderMapService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean checkNonce(String nonce) {
        if (StringUtils.isBlank(nonce)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "nonce不能为空");
        }
        String nonceKey = "apiCenter:headerMap:nonce:" + nonce;
        if (Boolean.FALSE.equals(redisTemplate.hasKey(nonceKey))) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "nonce不存在");
        }
        redisTemplate.delete(nonceKey);
        return true;
    }

}