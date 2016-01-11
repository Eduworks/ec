package com.eduworks.ec.service.user;

import org.stjs.javascript.JSObjectAdapter;

import com.eduworks.ec.callback.EcCallback;
import com.eduworks.ec.remote.EcRemote;

public class EcLogin
{
	private static final String LOGIN = "login";
	public static String token = "";
	public static boolean isLoggedIn = false;

	public static void login(String username, String password, final EcCallback success, final EcCallback failure)
	{
		EcLoginCredentials c = new EcLoginCredentials(username, password);
		EcRemote.httpPost(LOGIN, c, new EcCallback()
		{
			@Override
			public void callback(Object object)
			{
				token = (String) JSObjectAdapter.$properties(object).$get("token");
				isLoggedIn = true;
				success.callback(object);
			}
		}, new EcCallback()
		{
			@Override
			public void callback(Object object)
			{
				token = null;
				isLoggedIn = false;
				failure.callback(object);
			}
		});
	}
}
