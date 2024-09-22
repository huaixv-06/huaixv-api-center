package com.huaixv06.apicenterinterface.controller;



import com.huaixv06.apicenterclientsdk.modal.User;
import com.huaixv06.apicenterclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("huaixv06"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {

//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        // 实际情况应该是去数据库中查是否已分配给用户
//        if (!accessKey.equals("huaixv06")) {
//            throw new RuntimeException("无权限");
//        }
//        // 使用hashmap或者redis存储 nonce，防止重复调用
//        if (Long.parseLong(nonce) > 10000) {
//            throw new RuntimeException("无权限");
//        }
//        //时间和当前时间不能超过 5 分钟
////        if (timestamp) {
////
////        }
//        //实际情况中是从数据库中查出 secretKey
//        String serverSign = SignUtils.getSign(body, "123456");
//        if (!sign.equals(serverSign)) {
//            throw new RuntimeException("无权限");
//        }

        return "POST 用户名字是" + user.getUserName();
    }

}
