package com.example.demo.exception;

import com.example.demo.exception.custom.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> emailAlreadyExists(EmailAlreadyException emailEx){

        return new ResponseEntity<>(
                createMessage(ErrorType.EMAIL_ALREADY_EXISTS)
                , HttpStatus.BAD_GATEWAY);
    }



    @ExceptionHandler(PasswordLoginException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> passwordLoginException(PasswordLoginException passEx){
        return new ResponseEntity<>(
                createMessage(ErrorType.PASSWORD_NOT_MATCH)
                ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> ownerNotFoundException(OwnerNotFoundException ex){
        return new ResponseEntity<>(
                createMessage(ErrorType.OWNER_NOT_FOUND_EXCEPTION)
                ,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(TokenNotEmptyException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> tokenNotEmpty(TokenNotEmptyException ex){

        return new ResponseEntity<>(
                createMessage(ErrorType.WRONG_TOKEN)
                ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmailNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> emailNotValid(EmailNotValidException ex){

        return new ResponseEntity<>(
                createMessage(ErrorType.EMAIL_NOT_VALID)
                ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRoleException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> invalidRoleException(InvalidRoleException ex){

        return new ResponseEntity<>(
                createMessage(ErrorType.INVALID_ROLE)
                ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidFieldException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> invalidFieldException(InvalidFieldException ex){

        return new ResponseEntity<>(
                createMessage(ErrorType.INVALID_FIELD)
                ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(QuestionNotExistsException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> questionNotExistException(InvalidFieldException ex){

        return new ResponseEntity<>(
                createMessage(ErrorType.QUESTION_NOT_EXIST)
                ,HttpStatus.BAD_REQUEST);
    }




    public ErrorMessage createMessage(ErrorType errorType){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.message= errorType.message;
        errorMessage.statucCode=errorType.statusCode;
        return errorMessage;
    }
}
