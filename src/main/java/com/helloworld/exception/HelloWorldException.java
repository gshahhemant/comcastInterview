package com.helloworld.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Hemant Shah
 */
public class HelloWorldException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	private HttpStatus httpCode = HttpStatus.INTERNAL_SERVER_ERROR;
	private String description;
	private String reasonCode;

	public HelloWorldException () {

	}

	public HelloWorldException (HttpStatus httpCode, String description, String reasonCode) {
		this.httpCode = httpCode;
		this.description = description;
		this.reasonCode = reasonCode;
	}

	public HelloWorldException (String description, String reasonCode) {
		this(HttpStatus.INTERNAL_SERVER_ERROR, description, reasonCode);
	}

	public HelloWorldException (String message, Throwable cause) {
		super(message, cause);
	}

	public HelloWorldException (HttpStatus httpCode, String description, String reasonCode, Throwable cause) {
		super(description, cause);
		this.httpCode = httpCode;
		this.description = description;
		this.reasonCode = reasonCode;
	}

	public HelloWorldException (String description, String reasonCode, Throwable cause) {
		this(HttpStatus.INTERNAL_SERVER_ERROR, description, reasonCode, cause);
	}

	public HttpStatus getHttpCode() {
		return this.httpCode;
	}

	public void setHttpCode(HttpStatus httpCode) {
		this.httpCode = httpCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReasonCode() {
		return this.reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public HelloWorldException(HelloWorldExceptionCode code) {
		this(code.getHttpCode(), code.getDescription(), code.getCode());
	}

	public HelloWorldException(HelloWorldExceptionCode code, Throwable cause) {
		this(code.getHttpCode(), code.getDescription(), code.getCode(), cause);
	}
}
