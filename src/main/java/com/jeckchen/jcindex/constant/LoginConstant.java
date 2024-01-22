package com.jeckchen.jcindex.constant;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
    private String defaultUsername;
    @Value("${jc.login.default.password}")
    private String defaultPassword;
    @Value("${jc.login.admin.username}")
    private String adminUsername;
    @Value("${jc.login.admin.password}")
    private String adminPassword;

    public static String DEFAULT_USER_NAME;
    public static String DEFAULT_USER_PASSWORD;
    public static String ADMIN_USER_NAME;
    public static String ADMIN_USER_PASSWORD;

    @PostConstruct
    public void init() {
        DEFAULT_USER_NAME = defaultUsername;
        DEFAULT_USER_PASSWORD = defaultPassword;
        ADMIN_USER_NAME = adminUsername;
        ADMIN_USER_PASSWORD = adminPassword;
    }

}
