package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistException extends RuntimeException{
    
    String message;
    HttpStatus status;

    public EmailAlreadyExistException(String message, HttpStatus status){
        this.message=message;
        this.status=status;
    }

}
