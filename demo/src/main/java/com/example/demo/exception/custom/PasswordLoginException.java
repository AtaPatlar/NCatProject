package com.example.demo.exception.custom;

public class PasswordLoginException extends RuntimeException{

    public PasswordLoginException(String message){
        super(message);
    }

    public PasswordLoginException() {
        super();
    }
}
