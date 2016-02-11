package com.eduworks.ec.service.user.model;

import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.service.user.SessionManager;
import com.eduworks.ec.service.user.display.SessionInterface;

public class Session {
	public static void login(String username, String password, final SessionInterface view)
	{
		SessionManager.login(username, password, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				view.loginSuccess();
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				view.loginFailure(p1);				
			}
		});
	}
	
	public static void logout(final SessionInterface view)
	{
		SessionManager.logout(new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				view.logoutSuccess();
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
					
			}
		});
	}
}
