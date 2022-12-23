package com.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DoctorExceptionController {
	
	@ExceptionHandler(value = DoctorNotFoundException.class)
	public ResponseEntity<Object> exception(DoctorNotFoundException exception){
		return new ResponseEntity<>("Doctor Not Found", HttpStatus.NOT_FOUND);
	}

}
