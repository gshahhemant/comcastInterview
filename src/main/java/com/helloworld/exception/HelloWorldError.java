package com.helloworld.exception;


import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * @author Hemant Shah
 */

public class HelloWorldError implements Serializable {

	private static final long serialVersionUID = -3049486389924482857L;
	private Date currentTime = new Date();
	private HttpStatus httpStatus;
	private String reasonCode;
	private String message;
	private String detailMessage;

	public HelloWorldError(HttpStatus httpStatus, String reasonCode, String message) {
		this.httpStatus = httpStatus;
		this.reasonCode = reasonCode;
		this.message = message;
	}

	public HelloWorldError(HttpStatus httpStatus, String reasonCode, String message, String detailMessage) {
		this.httpStatus = httpStatus;
		this.reasonCode = reasonCode;
		this.message = message;
		this.detailMessage = detailMessage;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

}
