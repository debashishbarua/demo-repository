package com.cts.exception;

import org.springframework.http.HttpStatus;

public class ErrorRespone {
	
	private String errorMessage;
	private HttpStatus httpStatus;
	
	public ErrorRespone() {
		
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
}
