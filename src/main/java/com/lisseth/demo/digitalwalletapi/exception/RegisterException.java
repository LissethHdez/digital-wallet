package com.lisseth.demo.digitalwalletapi.exception;

import lombok.Getter;

@Getter
public class RegisterException extends RuntimeException{

    private int httpStatus;

    public  RegisterException(String message, int httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

}
