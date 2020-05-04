package com.demoapp.request;

import java.io.Serializable;

public class UserRoleRequest implements Serializable{

	private static final long serialVersionUID = 6405325501327368597L;
	
	private String userCode;
	
	private String role;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRoleRequest [userCode=").append(userCode).append(", role=").append(role).append("]");
		return builder.toString();
	}
	
}
