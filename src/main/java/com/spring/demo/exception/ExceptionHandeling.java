package com.spring.demo.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.demo.domain.HttpResponse;

public class ExceptionHandeling implements ErrorController {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<HttpResponse> patientNotFoundException(PatientNotFoundException exception) {
		return createHttpResponse(HttpStatus.BAD_REQUEST, exception.getMessage());

	}

	@ExceptionHandler(UsernameExistException.class)
	public ResponseEntity<HttpResponse> userNameExistException(UsernameExistException exception) {
		return createHttpResponse(HttpStatus.BAD_REQUEST, exception.getMessage());

	}

	private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
		return new ResponseEntity<HttpResponse>(new HttpResponse(httpStatus.value(), httpStatus,
				httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase()), httpStatus);
	}

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<HttpResponse> adminNotFoundException(AdminNotFoundException adminNotFoundException) {
		return createHttpResponse(HttpStatus.BAD_REQUEST, adminNotFoundException.getMessage());

	}

	@ExceptionHandler(PrescriptionNotFoundException.class)
	public ResponseEntity<HttpResponse> prescriptionNotFoundException(PrescriptionNotFoundException prescriptionNotFoundException) {
		return createHttpResponse(HttpStatus.BAD_REQUEST, prescriptionNotFoundException.getMessage());

	}
}
