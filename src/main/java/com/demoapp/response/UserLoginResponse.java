package com.demoapp.response;

import java.io.Serializable;

public class UserLoginResponse implements Serializable{

	private static final long serialVersionUID = -4499489162375242769L;
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserLoginResponse [token=").append(token).append("]");
		return builder.toString();
	}
	
}
