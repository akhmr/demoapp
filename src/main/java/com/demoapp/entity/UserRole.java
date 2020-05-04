package com.demoapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole extends AbstractEntity<Long> implements Serializable{
	private static final long serialVersionUID = 291958546195955380L;
	
	@Column(name = "user_code")
	private String userCode;
	
	@Column(name = "role")
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
		builder.append("UserRole [userCode=").append(userCode).append(", role=").append(role).append("]");
		return builder.toString();
	}
	
}
