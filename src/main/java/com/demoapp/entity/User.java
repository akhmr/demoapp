package com.demoapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 2855026394502947912L;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "code")
	private String code;

	@Column(name = "password")
	private String password;

	@Column(name = "hash_code")
	private String hashCode;

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

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
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
		builder.append("User [name=").append(name).append(", email=").append(email).append(", phoneNo=").append(phoneNo)
				.append(", code=").append(code).append(", password=").append(password).append(", hashCode=")
				.append(hashCode).append("]");
		return builder.toString();
	}

}
