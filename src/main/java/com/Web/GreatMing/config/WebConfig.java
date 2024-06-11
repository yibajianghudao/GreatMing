package com.Web.GreatMing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.Web.GreatMing.interceptors.Logininterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Autowired
    private Logininterceptor logininterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 放行登录和注册接口
        registry.addInterceptor(logininterceptor).excludePathPatterns("/user/login", "user/register");

    }

}
