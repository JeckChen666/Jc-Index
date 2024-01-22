package com.jeckchen.jcindex.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.jeckchen.jcindex.constant.LoginConstant;
import com.jeckchen.jcindex.pojo.NormalHomeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author JeckChen
 * @version 1.0.0
 * @className IndexController.java
 * @description 控制器
 * @date 2024年01月19日 09:37
 */

@Controller
@Slf4j
public class IndexController {
    @PostMapping("/login/verify")
    public String loginVerify(@RequestParam String password, Model model) {
        // 校验用户名和密码，这里简单演示，实际应用中需要校验数据库中的用户信息
        if (LoginConstant.USER_PASSWORD.equals(password)) {
            // 登录成功，给用户颁发令牌
            StpUtil.login(LoginConstant.USER_NAME);
            // 登录成功后跳转到首页或其他页面
            return "redirect:/home";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            // 登录失败，返回登录页面
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/", "/home"})
    public String index(Model model) {
        model.addAttribute("info", NormalHomeDTO.getInstance());
        return "home";
    }
}
