package com.demoapp.request;

import java.io.Serializable;

public class UserLoginRequest implements Serializable{
	private static final long serialVersionUID = -4517125686441674722L;

	private String emailOrPhoneNo;
	
	private String password;

	public String getEmailOrPhoneNo() {
		return emailOrPhoneNo;
	}

	public void setEmailOrPhoneNo(String emailOrPhoneNo) {
		this.emailOrPhoneNo = emailOrPhoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserLoginRequest [emailOrPhoneNo=").append(emailOrPhoneNo).append(", password=")
				.append(password).append("]");
		return builder.toString();
	}
	
}
