package com.helloworld.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HelloWorldExceptionHandler extends  ResponseEntityExceptionHandler {

	@Value("${spring.application.name}")
	private String servicName;
	
	@Value("${hemant.shah}")
	private String myName;

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(value = HelloWorldException.class)
	public ResponseEntity<HelloWorldError> handleException(HelloWorldException exception) {
		HelloWorldError helloWorldError = new HelloWorldError(exception.getHttpCode(), exception.getReasonCode(), exception.getDescription(), exception.toString());
		return new ResponseEntity<HelloWorldError>(helloWorldError, exception.getHttpCode());

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		System.out.println(myName);


		BindingResult  bindingResult = ex.getBindingResult();
		List<String> errors = new ArrayList<>();
		bindingResult.getFieldErrors().forEach(fieldError -> {
			/*String message;
			try {
				message = messageSource.getMessage(fieldError, Locale.ENGLISH);
			}catch(NoSuchMessageException e) {
				message ="Invalid Input";
			}*/
			 if(fieldError.getField().equalsIgnoreCase("firstName")) {
				 errors.add(fieldError.getField() + ":" + HelloWorldExceptionCode.CUSOMER_FIRST_NAME_INVALID.getCode() +HelloWorldExceptionCode.CUSOMER_FIRST_NAME_INVALID.getDescription());
			 }
			 if(fieldError.getField().equalsIgnoreCase("lastName")) {
				 errors.add(fieldError.getField() + ":" + HelloWorldExceptionCode.CUSOMER_LAST_NAME_INVALID.getCode() +HelloWorldExceptionCode.CUSOMER_LAST_NAME_INVALID.getDescription());
			 }
			 if(fieldError.getField().equalsIgnoreCase("phoneNumber")) {
				 errors.add(fieldError.getField() + ":" + HelloWorldExceptionCode.CUSOMER_PRHONE_NUMBER_INVALID.getCode() +HelloWorldExceptionCode.CUSOMER_PRHONE_NUMBER_INVALID.getDescription());
			 }
			
			//errors.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
		});
		bindingResult.getGlobalErrors().forEach(objectError -> {
			errors.add(objectError.getObjectName() + ":" +objectError.getDefaultMessage());
		});

		HelloWorldError helloWorldError = new HelloWorldError(status,servicName,"Input validation errors");
		helloWorldError.setValidationErrors(errors);
		return new ResponseEntity<>(helloWorldError, status);
	}
}
