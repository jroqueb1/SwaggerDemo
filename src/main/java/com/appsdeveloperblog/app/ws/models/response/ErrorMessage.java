package com.appsdeveloperblog.app.ws.models.response;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String message;
	private String request;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
