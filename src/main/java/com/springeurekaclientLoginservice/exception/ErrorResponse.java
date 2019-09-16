package com.springeurekaclientLoginservice.exception;




import java.time.LocalDate;

public class ErrorResponse {
	
	
	private LocalDate timestamp;

	private String message;

	private int statusCode;
	
	
	

	public ErrorResponse(LocalDate timestamp, String message, int statusCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.statusCode = statusCode;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
