package com.Web.GreatMing.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.util.StringUtils;

import com.Web.GreatMing.Response;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public Response<?> handleException(Exception e){
        // e.printStackTrace();
        System.out.println(e.getMessage());
        return Response.newFail(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "输出错误信息失败,该错误类型没有实现getMessage方法");
    }
}
