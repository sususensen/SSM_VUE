package com.me.test.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2019/4/25 11:46
 * @atuther net source
 */
public class JwtUtil {

    //密钥
    public static final String SECRET = "sgfdsopljkhsl;o437632";
    //过期时间:秒
    public static final int EXPIRE = 1000;

    /**
     * 生成Token
     * @param username
     * @return
     * @throws Exception
     */
    public static String createToken(String username) throws Exception {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        return JWT.create()
                .withHeader(map)//头
                .withClaim("username", username)
                .withSubject("测试")//
                .withIssuedAt(new Date())//签名时间
                .withExpiresAt(expireDate)//过期时间
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证Token
     * @param token
     * @return
     * @throws Exception
     */
    public static boolean verifyToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            verifier.verify(token);
            return true;  // 验证成功，返回 true
        } catch (Exception e) {
            // 验证失败，返回 false
            return false;
        }
    }


    /**
     * 解析Token
     * @param token
     * @return
     */
    public static Map<String, Claim> parseToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims();
    }

}
