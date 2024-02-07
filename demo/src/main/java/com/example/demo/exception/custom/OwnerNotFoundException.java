package com.example.demo.exception.custom;

public class OwnerNotFoundException extends RuntimeException{

    public OwnerNotFoundException (String message){
        super(message);
    }
    public OwnerNotFoundException(){
        super();
    }
}
