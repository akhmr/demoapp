package com.demoapp.request;

public class CreateUserRequest {

	private String name;

	private String email;

	private String phoneNo;
	
	private String password;

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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateUserRequest [name=").append(name).append(", email=").append(email).append(", phoneNo=")
				.append(phoneNo).append(", password=").append(password).append("]");
		return builder.toString();
	}

}
