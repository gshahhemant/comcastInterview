package com.helloworld.exception;

import org.springframework.http.HttpStatus;


public enum HelloWorldExceptionCode {


	NO_APPS_FOUND("0001", "No Apps Found", HttpStatus.NOT_FOUND),
	INVALID_APPID("0002", "Invalid AppId", HttpStatus.BAD_REQUEST),
	NO_USERS_FOUND("0003", "No Users Found", HttpStatus.NOT_FOUND),
	INPUT_FIELD_VALIDATION_FAILED("0004", "One or more fields of AppInfo are Blank or Null ", HttpStatus.BAD_REQUEST),
	NO_CUSTOMBER_FOUND("0001", "No Custombers Found", HttpStatus.NOT_FOUND);

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
