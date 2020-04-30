package com.demoapp.response;

public class CreateUserRequest {

	private String name;

	private String email;

	private String phoneNo;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateUserRequest [name=").append(name).append(", email=").append(email).append(", phoneNo=")
				.append(phoneNo).append("]");
		return builder.toString();
	}

}
