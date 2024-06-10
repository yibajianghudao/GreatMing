package com.Web.GreatMing;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response <T> {
    
    private T data;
    private Integer code;
    private String message;

    public static <K> Response<K> newSuccess(K data, String successMsg) {
        Response<K> response = new Response<>();
        response.setData(data);
        response.setCode(1);
        response.setMessage(successMsg);
        return response;

    }

    // 最少返回一个字符串表达成功或失败
    public static <K> Response<K> newSuccess(String successMsg) {
        Response<K> response = new Response<>();
        response.setCode(1);
        response.setMessage(successMsg);
        return response;

    }


    public static Response<Void> newFail(String errorMsg){
        Response<Void> response = new Response<>();
        response.setMessage(errorMsg);
        response.setCode(0);
        return response;
    }

}
