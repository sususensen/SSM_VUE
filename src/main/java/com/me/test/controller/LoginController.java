package com.me.test.controller;

import com.me.test.pojo.LoginInfo;
import com.me.test.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/get")
    @ResponseBody
    public String getToken(@RequestBody LoginInfo loginInfo) {
        // 在这里可以访问 loginRequest.getUsername() 和 loginRequest.getPassword() 来获取前端发送的参数

        String token=loginService.logIn(loginInfo);
        return token;
    }
}
