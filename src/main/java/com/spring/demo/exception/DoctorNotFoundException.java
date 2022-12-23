package com.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends RuntimeException{
	
	private static final long seriolVersionUID = 1L;
	
	private String message;
	
	public DoctorNotFoundException() {}
	
	public DoctorNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}