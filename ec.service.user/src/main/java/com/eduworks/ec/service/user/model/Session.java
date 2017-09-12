package com.eduworks.ec.service.user.model;

import com.eduworks.ec.service.user.SessionManager;
import org.stjs.javascript.functions.Callback1;

/**
 * Session 
 * @author djunker
 *
 */
public class Session {
	public static void login(String username, String password, Callback1<Object> success, Callback1<String> failure)
	{
		SessionManager.login(username, password, success, failure);
	}
	
	public static void logout(Callback1<Object> success, Callback1<String> failure)
	{
		SessionManager.logout(success, failure);
	}
}
