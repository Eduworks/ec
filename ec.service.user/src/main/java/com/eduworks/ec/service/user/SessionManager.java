package com.eduworks.ec.service.user;

import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallback;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.ec.service.user.model.EcLoginCredentials;
import com.eduworks.ec.service.user.model.User;

public class SessionManager
{
	private static String selectedServer = "http://localhost:9722/api/custom";
	
	private static final String LOGIN = "login";

	
	private static String sessionId = "";
	private static boolean isLoggedIn = false;
	
	private static User currentUser = null;
	
	public static void setServer(String server)
	{
		selectedServer = server;
	}
	
	public static String getSessionId()
	{
		return sessionId;
	}
	
	public static boolean getLoggedIn()
	{
		return isLoggedIn;
	}

	public static void login(String username, String password, final EcCallback success, final EcCallback failure)
	{
		EcLoginCredentials c = new EcLoginCredentials(username, password);
		FormData fd = new FormData();
		fd.append("user", JSGlobal.JSON.stringify(c));
		EcRemote.postExpectingObject(selectedServer,LOGIN, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				sessionId = (String) JSObjectAdapter.$properties(object).$get("sessionId");
				isLoggedIn = true;
				
				currentUser = User._parse(object);
				
				success.callback(object);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				sessionId = null;
				isLoggedIn = false;
				failure.callback(p1);				
			}
		});
	}
}
