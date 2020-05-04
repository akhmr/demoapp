package com.demoapp.request;

import java.util.List;

public class CreateRoleRequest {
	
	private String role;
	
	private String serviceName;
	
	private List<String> allowedUrls;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<String> getAllowedUrls() {
		return allowedUrls;
	}

	public void setAllowedUrls(List<String> allowedUrls) {
		this.allowedUrls = allowedUrls;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateRoleRequest [role=").append(role).append(", serviceName=").append(serviceName)
				.append(", allowedUrls=").append(allowedUrls).append("]");
		return builder.toString();
	}
	
	

}
