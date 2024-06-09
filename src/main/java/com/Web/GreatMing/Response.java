package com.Web.GreatMing;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response <T> {
    
    private T data;
    private boolean success;
    private String errorMsg;

    public static <K> Response<K> newSuccess(K data) {
        Response<K> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;

    }

    public static Response<Void> newFail(String errorMsg){
        Response<Void> response = new Response<>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }

}
