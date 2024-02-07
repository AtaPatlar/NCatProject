package com.example.demo.exception;

public enum ErrorType {

    EMAIL_ALREADY_EXISTS(15001,"Email already exists"),
    EMAIL_NOT_VALID(15004,"Email not valid"),
    PASSWORD_NOT_MATCH(15003,"Password not match"),
    OWNER_NOT_FOUND_EXCEPTION(15002,"Owner Not Found"),
    INVALID_ROLE(17001,"Invalid Role"),
    INVALID_FIELD(17003,"Invalid field"),
    WRONG_TOKEN(16002,"Wrong token"),
    QUESTION_NOT_EXIST(18001,"Question not exist");

    ErrorType(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    int statusCode;
    String message;
}
