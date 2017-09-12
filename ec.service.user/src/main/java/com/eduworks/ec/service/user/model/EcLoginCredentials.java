package com.eduworks.ec.service.user.model;

public class EcLoginCredentials {
	public String userId;
	public String password;

	public EcLoginCredentials(String username, String password) {
		this.userId = username;
		this.password = password;
	}
}