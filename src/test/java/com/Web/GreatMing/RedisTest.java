package com.Web.GreatMing;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import lombok.val;

@SpringBootTest // 单元测试方法执行之前先初始化spring容器
public class RedisTest {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        // 往redis中存储一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        
        operations.set("username", "Gustav");
        operations.set("id", "1", 15, TimeUnit.SECONDS);
    }

    @Test
    public void testDelet(){
        // 往redis中存储一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        
        stringRedisTemplate.delete("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsibmFtZSI6Ikd1c3RhdiIsImlkIjozfSwiZXhwIjoxNzE5MjUzMDY0fQ.zC9h8-tEScmpF_KiDMUX4jdIDXxOQQsbSPY1SPvyV-c");
    }

    @Test
    public void testGet(){
        // 获取一个键值对
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        // 获取key对应的值
        // System.out.println(operations.get(""));
        // 获取所有key
        for(String key : stringRedisTemplate.keys("*")){
            String value = operations.get(key);
            System.out.println(key + ":" + value);
            
        }
    }

}
