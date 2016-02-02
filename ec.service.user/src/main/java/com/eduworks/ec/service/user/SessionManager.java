package com.eduworks.ec.service.user;

import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallback;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class SessionManager
{
	private static String selectedServer = "http://localhost:9722/api/custom";
	
	private static final String LOGIN = "login";
	
	
	public static String token = "";
	public static boolean isLoggedIn = false;
	
	public static void setServer(String server)
	{
		selectedServer = server;
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
				token = (String) JSObjectAdapter.$properties(object).$get("token");
				isLoggedIn = true;
				success.callback(object);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				token = null;
				isLoggedIn = false;
				failure.callback(p1);				
			}
		});
	}
}
