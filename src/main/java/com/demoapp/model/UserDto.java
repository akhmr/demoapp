package com.demoapp.model;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 3187101169971845654L;
	
	private String name;

	private String email;

	private String phoneNo;

	private String code;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDto [name=").append(name).append(", email=").append(email).append(", phoneNo=")
				.append(phoneNo).append(", code=").append(code).append("]");
		return builder.toString();
	}
	
}
