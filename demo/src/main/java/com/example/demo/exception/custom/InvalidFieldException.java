package com.example.demo.exception.custom;

public class InvalidFieldException extends RuntimeException{
    public InvalidFieldException(String message){
        super(message);
    }

    public InvalidFieldException(){super();}
}
