package com.Web.GreatMing.exception;

public class PasswordWrongException extends RuntimeException {
    
    private String message;

    public PasswordWrongException(String message){
        super(message);
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
