package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{

    String message;
    HttpStatus status;

    public ResourceNotFoundException(String message, HttpStatus status) {
        this.message=message;
        this.status=status;
    }


    
    @Override
    public String getMessage(){
        return message;
        
    }
    


    
}
