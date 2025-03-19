package com.Web.GreatMing.interceptors;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.Web.GreatMing.exception.MessageException;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.ThreadLocalUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Logininterceptor implements HandlerInterceptor {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    // 请求接口前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        // 令牌验证
        String token = request.getHeader("Authorization");
//        System.out.println(token);
        Map<String, Object> map = jwtUtil.parseToken(token);
        Integer idiInteger =  (Integer) map.get("id");
        Long id = idiInteger.longValue();
        String keyString = id.toString();
        try {
            // 从redis中获取相同的Token
            ValueOperations operations = stringRedisTemplate.opsForValue();
            String redisToken = (String) operations.get(keyString);
            // System.out.println(keyString);
            // System.out.println(redisToken);
            if (redisToken == null) {
                // token已失效
//                 System.out.println(token);
                throw new RuntimeException();
            }else if (!redisToken.equals(token)){
                // token不正确
                // System.out.println("token不正确");
                throw new RuntimeException();
            }

            Map<String, Object> claims = jwtUtil.parseToken(token);
            // 把数据存储到ThreadLocal,记录当前用户的token
            ThreadLocalUtil.set(claims);

            return true;
        }catch (Exception e){
            // 设置状态码response为401
            response.setStatus(401);
            throw new MessageException("未登录,请先登录."); // 返回状态码是否会直接显示一个页面？那样就不需要返回信息了吧.
            // return false;
        }

    }

    // 请求接口后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }


}
