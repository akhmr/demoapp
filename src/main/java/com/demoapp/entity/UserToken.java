package com.demoapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_token")
public class UserToken extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = 1514367414338216422L;

	@Column(name = "user_code")
	private String usercode;
	
	private String token;
	
	@Column(name = "token_expairy_time")
	private Long   tokenExpairyTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getTokenExpairyTime() {
		return tokenExpairyTime;
	}

	public void setTokenExpairyTime(Long tokenExpairyTime) {
		this.tokenExpairyTime = tokenExpairyTime;
	}
	
	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserToken [usercode=").append(usercode).append(", token=").append(token)
				.append(", tokenExpairyTime=").append(tokenExpairyTime).append("]");
		return builder.toString();
	}

}
