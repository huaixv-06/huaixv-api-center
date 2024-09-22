package com.huaixv06.apicenterinterface;

import com.huaixv06.apicenterclientsdk.client.ApiCenterClient;

import com.huaixv06.apicenterclientsdk.modal.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiCenterInterfaceApplicationTests {

    @Resource
    private ApiCenterClient apiCenterClient;

    @Test
    void contextLoads() {
        String result =  apiCenterClient.getNameByGet("huaixv06");
        User user = new User();
        user.setUserName("huaixv06");
        String usernameByPost = apiCenterClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
