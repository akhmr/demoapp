package com.demoapp.response;

import java.io.Serializable;

public class CreateUserResponse implements Serializable{

	private static final long serialVersionUID = 2863871871542169088L;
	
	private Boolean created;

	public Boolean getCreated() {
		return created;
	}

	public void setCreated(Boolean created) {
		this.created = created;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateUserResponse [created=").append(created).append("]");
		return builder.toString();
	}
	
}
