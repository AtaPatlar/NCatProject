package com.example.demo.exception.custom;

public class EmailAlreadyException  extends RuntimeException{
    public EmailAlreadyException(String message){
        super(message);
    }

    public EmailAlreadyException(){
        super();
    }
}
