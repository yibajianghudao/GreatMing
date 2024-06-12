package com.Web.GreatMing.exception;

// 准备使用此异常给全局异常处理器捕获
public class MessageException extends RuntimeException {

    private String message;

    public MessageException(String message){
        super(message);
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}
