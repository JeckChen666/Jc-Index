package com.jeckchen.jcindex.config;

import com.jeckchen.jcindex.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author JeckChen
 * @version 1.0.0
 * @className WebMvcConfig.java
 * @description WebMvcConfig
 * @date 2024年01月19日 10:42
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    String[] excludePathPatterns = {"/login", "/login/verify", "/static/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义拦截器，并指定拦截的路径
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                // 排除不需要拦截的路径
                .excludePathPatterns(excludePathPatterns);
    }
}