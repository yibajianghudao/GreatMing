package com.Web.GreatMing;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTest {
    

    @Test
    public void testGen(){

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");

        String token = JWT.create()
                .withClaim("user", claims) //载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*3)) //过期时间-3小时
                .sign(Algorithm.HMAC256("greatming")); //密钥配置（最好写到配置文件中）
        System.out.println("token:"+token);    
    }

    @Test
    public void testParse(){
        String token = "";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("greatming")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
        // token失效可能性：篡改头部或载荷部数据，修改加密算法，token过期
    }
}
