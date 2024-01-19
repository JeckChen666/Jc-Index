package com.jeckchen.jcindex.constant;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author JeckChen
 * @version 1.0.0
 * @className LoginConstant.java
 * @description 登录默认账号密码
 * @date 2024年01月19日 13:49
 */
@Data
@Component
public class LoginConstant {

    @Value("${jc.login.default.username}")
    private String username;
    @Value("${jc.login.default.password}")
    private String password;

    public static String USER_NAME;
    public static String USER_PASSWORD;

    @PostConstruct
    public void init() {
        USER_NAME = username;
        USER_PASSWORD = password;
    }

}
