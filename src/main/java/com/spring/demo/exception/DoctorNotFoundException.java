package com.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends RuntimeException {
	
	public DoctorNotFoundException() {
		super();
		//System.out.println("Error");
	}
//
}