package com.demoapp.response;

import java.io.Serializable;

public class Response<T> extends BaseResponse implements Serializable {

	private static final long serialVersionUID = 9130745770699713737L;

	private T data;

	public Response(T data) {
		    super();
			this.data = data;
	}

	public Response() {
		super();
	}


	public Response(String statusCode, String message) {
		super(statusCode, message);
	}

	public Response(String statusCode, String message, T data) {
		super(statusCode, message);
		this.data = data;
	}


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

