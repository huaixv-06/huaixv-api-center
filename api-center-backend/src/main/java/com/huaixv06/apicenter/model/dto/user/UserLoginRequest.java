package com.huaixv06.apicenter.model.dto.user;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author yupi
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    @JsonIgnore
    private boolean autoLogin;

    private String userAccount;

    private String userPassword;
}
