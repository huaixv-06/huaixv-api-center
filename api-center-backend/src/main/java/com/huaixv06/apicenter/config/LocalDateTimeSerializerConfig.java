package com.huaixv06.apicenter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class LocalDateTimeSerializerConfig {
    @Bean
    public ObjectMapper customObjectMapper() {
        // 创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        // 设置日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 返回ObjectMapper对象
        return objectMapper;
    }
}
