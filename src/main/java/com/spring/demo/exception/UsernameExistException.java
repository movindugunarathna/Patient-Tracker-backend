package com.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsernameExistException extends Exception{

	private static final long serialVersionUID = 1L;

	public UsernameExistException(String message) {
		super(message);
	}

}
