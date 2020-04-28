package com.demoapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role extends AbstractEntity<Long> implements Serializable{

	private static final long serialVersionUID = -2739442269215680659L;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "service_name")
	private String serviceName;
	
	@Column(name = "role_url")
	private String url;


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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [role=").append(role).append(", serviceName=").append(serviceName).append(", url=")
				.append(url).append("]");
		return builder.toString();
	}

	
}
