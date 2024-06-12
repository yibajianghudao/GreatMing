package com.Web.GreatMing.exception;

public class PasswordWrongException extends RuntimeException {
    
    private String message;

    public PasswordWrongException(String message){
        super(message);
        this.message = message;
    }
    // 满足全局异常处理器的调用,上面super(message)的时候就已经继承了该方法，此处仅仅是为了不提示警告
    public String getMessage(){
        return message;
    }
}
