package com.demoapp.request;

import java.io.Serializable;

import com.demoapp.constant.LoginBy;

public class UserLoginRequest implements Serializable{
	private static final long serialVersionUID = -4517125686441674722L;

	private String emailOrPhoneNo;
	
	private String password;
	
	private LoginBy loginBy;

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
	
	public LoginBy getLoginBy() {
		return loginBy;
	}

	public void setLoginBy(LoginBy loginBy) {
		this.loginBy = loginBy;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserLoginRequest [emailOrPhoneNo=").append(emailOrPhoneNo).append(", password=")
				.append(password).append(", loginBy=").append(loginBy).append("]");
		return builder.toString();
	}

}
