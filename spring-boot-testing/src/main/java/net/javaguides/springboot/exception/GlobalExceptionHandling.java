package net.javaguides.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import net.javaguides.springboot.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandling {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        System.out.println("Inside handleResourceNotFoundException Method "+ex.message +" "+ex.getMessage());
        ErrorResponse errorResponse=new ErrorResponse(new Date(),ex.message,ex.status);
        return new ResponseEntity<ErrorResponse>(errorResponse, ex.status);

    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<String> handleEmailAlreadyExistException(EmailAlreadyExistException ex){
        System.out.println(ex.message);
        return new ResponseEntity<String>(ex.message, ex.status);
    }


}
