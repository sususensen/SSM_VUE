package com.me.test.service.impl;

import com.me.test.jwt.JwtUtil;
import com.me.test.pojo.LoginInfo;
import com.me.test.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String logIn(LoginInfo loginInfo) {
        String token="0";
        if(loginInfo.getUsername().equals("susen")&&loginInfo.getPassword().equals("123")) {

            try {
                token = JwtUtil.createToken(loginInfo.getUsername());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("生成token失败");
            }

        }return token;
    }
}
