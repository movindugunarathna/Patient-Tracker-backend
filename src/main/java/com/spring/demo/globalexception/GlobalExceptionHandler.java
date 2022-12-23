package com.spring.demo.globalexception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.demo.exception.DoctorNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<PostError> handleResourceNOtFoundException(DoctorNotFoundException exception,
			WebRequest webRequest){
		PostError postError = new PostError(new Date(),exception.getMessage(),webRequest.getDescription(false));
		
		return new ResponseEntity<>(postError, HttpStatus.NOT_FOUND);
	}
	

}
