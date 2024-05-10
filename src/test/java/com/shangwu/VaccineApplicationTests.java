package com.shangwu;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class VaccineApplicationTests {
    @Test
    void contextLoads() {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","qi");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "shangwu")// 设置签名算法
                .setClaims(claims) // 有效载荷
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置有效时间
                .compact();
        System.out.println(jwt);

    }

}
