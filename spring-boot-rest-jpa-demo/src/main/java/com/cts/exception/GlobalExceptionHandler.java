package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class used for Handling All Exception
 * 
 * @return
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorRespone> handleEmployeeNotFoundException(EmployeeNotFoundException e) {	
		ErrorRespone errorRespone=new ErrorRespone();
		errorRespone.setErrorMessage(e.getLocalizedMessage());
		errorRespone.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorRespone, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorRespone> handleException(EmployeeNotFoundException e) {
		ErrorRespone errorRespone=new ErrorRespone();
		errorRespone.setErrorMessage(e.getLocalizedMessage());
		errorRespone.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorRespone, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
