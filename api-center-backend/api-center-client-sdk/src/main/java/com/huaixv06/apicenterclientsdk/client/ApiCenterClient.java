package com.huaixv06.apicenterclientsdk.client;

import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.huaixv06.apicenterclientsdk.modal.User;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.huaixv06.apicenterclientsdk.utils.SignUtils.getSign;


/**
 * 调用第三方接口的客户端
 *
 * @author huaixv_06
 */
public class ApiCenterClient {

    private static final String GATEWAY_POST = "http://localhost:8090";

    private String accessKey;
    private String secretKey;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    public ApiCenterClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_POST + "/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }


    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post(GATEWAY_POST + "/api/name/post", paramMap);
        System.out.println(result);
        return result;
    }


    private Map<String,String> getHeaderMap(String body) {
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("accessKey",accessKey);
        // 一定不能直接发送
        // headerMap.put("secretKey",secretKey);
        // 生成唯一的UUID，作为请求标识之一
        String nonce = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String nonceKey = "apiCenter:headerMap:nonce:" + nonce;
        redisTemplate.opsForValue().set(nonceKey,nonce,300, TimeUnit.SECONDS);
        headerMap.put("nonce",nonce);
        headerMap.put("body",body);
        headerMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        headerMap.put("sign",getSign(body, secretKey));
        return headerMap;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_POST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

}
