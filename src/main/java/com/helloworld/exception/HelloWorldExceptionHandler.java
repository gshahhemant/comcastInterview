package com.helloworld.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Hemant Shah
 */

@ControllerAdvice
public class HelloWorldExceptionHandler extends  ResponseEntityExceptionHandler {

	@ExceptionHandler(value = HelloWorldException.class)
	public ResponseEntity<HelloWorldError> handleException(HelloWorldException exception) {
		HelloWorldError pixError = new HelloWorldError(exception.getHttpCode(), exception.getReasonCode(), exception.getDescription(), exception.toString());
		return new ResponseEntity<HelloWorldError>(pixError, exception.getHttpCode());

	}

}
