package com.example.demo.exception.custom;

public class InvalidRoleException extends RuntimeException{
    public InvalidRoleException() {
        super();
    }

    public InvalidRoleException(String message) {
        super(message);
    }
}
