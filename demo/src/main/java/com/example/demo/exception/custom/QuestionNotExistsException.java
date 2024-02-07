package com.example.demo.exception.custom;

public class QuestionNotExistsException  extends RuntimeException{
    public QuestionNotExistsException(String message){
        super(message);
    }

    public QuestionNotExistsException(){super();}

}
