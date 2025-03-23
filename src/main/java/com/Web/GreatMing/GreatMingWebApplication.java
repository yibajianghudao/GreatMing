package com.Web.GreatMing;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// import org.springframework.context.annotation.ComponentScan;
// @ComponentScan(basePackages = "com.greatming")	// 扫描指定包下的bean等，默认是该注解所在的类的包，已在SpringBootApplication注解中集成
@SpringBootApplication
@EnableCaching
@MapperScan("com.Web.GreatMing.dao") // 注册指定包下的所有Mapper接口并定义为bean
public class GreatMingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatMingWebApplication.class, args);
	}

}
