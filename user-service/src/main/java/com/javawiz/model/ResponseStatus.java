package com.javawiz.model;

public class ResponseStatus {
	private String statusText;
	private String statusCode;
	
	public ResponseStatus(String statusText, String statusCode){
		this.statusText = statusText;
		this.statusCode = statusCode;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
