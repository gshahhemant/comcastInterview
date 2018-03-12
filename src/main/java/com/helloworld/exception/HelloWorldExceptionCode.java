package com.helloworld.exception;

import org.springframework.http.HttpStatus;


public enum HelloWorldExceptionCode {

	NO_CUSTOMBER_FOUND("0001", "No Custombers Found", HttpStatus.NOT_FOUND),
	NO_TRANSACTION_FOUND("0002", "No Transaction Found", HttpStatus.NOT_FOUND),
	NO_USERS_FOUND("0003", "No Users Found", HttpStatus.NOT_FOUND);

	private static final String prefix = "HELLOWORLD";
	private final String code;
	private final String description;
	private final HttpStatus httpCode;

	HelloWorldExceptionCode(String code, String description) {
		this(code, description, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	HelloWorldExceptionCode(String code, String description, HttpStatus httpCode) {
		this.code = prefix + "_" + code;
		this.description = description;
		this.httpCode = httpCode;
	}
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public HttpStatus getHttpCode() {
		return httpCode;
	}
}
