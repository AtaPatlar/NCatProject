package com.example.demo.exception.custom;

public class TokenNotEmptyException extends RuntimeException{
    public TokenNotEmptyException(String message) {
        super(message);
    }

    public TokenNotEmptyException() {
        super();
    }
}
