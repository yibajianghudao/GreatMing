package com.Web.GreatMing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.Web.GreatMing.dao.TestUser;

@SpringBootTest
public class RedisTest {


    
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void RedisSerializeTest(){
        TestUser testUser = new TestUser();
        testUser.setId(1);
        testUser.setUsername("123");

        redisTemplate.opsForValue().set("testUser", testUser);
    }
}
