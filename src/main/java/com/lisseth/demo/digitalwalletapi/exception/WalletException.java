package com.lisseth.demo.digitalwalletapi.exception;

import lombok.Getter;

@Getter
public class WalletException extends RuntimeException{

    private int httpStatus;

    public WalletException(String message, int httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

}
