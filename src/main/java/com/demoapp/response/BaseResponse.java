package com.demoapp.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public abstract class BaseResponse {

    private String statusCode;

    private String message;


    public BaseResponse() {
        this.statusCode = "200";
        this.message="Success";
    }

    public BaseResponse(String statusCode, String message) {
    	 this.statusCode = statusCode;
         this.message=message;
    }

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseResponse [statusCode=").append(statusCode).append(", message=").append(message).append("]");
		return builder.toString();
	}


}

