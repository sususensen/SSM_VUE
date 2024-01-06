package com.me.test.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");
        logger.info(authorizationHeader);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // 去掉"Bearer "部分，获取实际的token
            if (JwtUtil.verifyToken(token)) {
                logger.info(token);
                return true;

            } else {
                // Token验证失败，返回错误信息
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               // response.getWriter().write("Token验证失败");

                return false;
            }
        } else {
            return false;
        }


    }

}

