package com.spring.demo.exception.ClerkExceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.demo.exception.ClerkNotFoundException;

@ControllerAdvice
public class ClerkControllerAdvice {
    
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
        return new ResponseEntity<String>("Input field is empty", HttpStatus.BAD_REQUEST);
    }

    // @ExceptionHandler(NoSuchElementException.class)
    // public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
    //     return new ResponseEntity<String>("Object Not Found", HttpStatus.NOT_FOUND);
    // }

    // @ExceptionHandler(ClerkNotFoundException.class)
    // public ResponseEntity<String> handleClerkNotFoundException(ClerkNotFoundException clerkNotFoundException){
    //     return new ResponseEntity<String>("No Clerk Found", HttpStatus.NOT_FOUND);
    // }
}
