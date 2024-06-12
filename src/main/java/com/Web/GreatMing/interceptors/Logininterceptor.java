package com.Web.GreatMing.interceptors;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.Web.GreatMing.exception.MessageException;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.ThreadLocalUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Logininterceptor implements HandlerInterceptor {
    
    // 请求接口前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        // 令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 把数据存储到ThreadLocal
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
