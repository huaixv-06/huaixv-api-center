package com.huaixv06.apicenterclientsdk;

import com.huaixv06.apicenterclientsdk.client.ApiCenterClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 读取配置文件中的apicenter.client前缀的配置
@ConfigurationProperties("apicenter.client")
@Data
// 扫描指定包下的类
@ComponentScan
public class ApiCenterClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ApiCenterClient apiCenterClient(){
        return new ApiCenterClient(accessKey, secretKey);
    }
}
