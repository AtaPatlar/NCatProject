package com.example.demo.exception.custom;

public class EmailNotValidException extends RuntimeException{

    public EmailNotValidException(String message){
        super(message);
    }
    public EmailNotValidException(){
        super();
    }

}
