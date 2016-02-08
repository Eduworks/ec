package com.eduworks.ec.service.user.display;

public interface SessionInterface {
	public void loginSuccess();
	public void loginFailure(Object error);
	public void logoutSuccess();
}
