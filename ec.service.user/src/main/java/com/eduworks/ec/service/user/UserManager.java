package com.eduworks.ec.service.user;

import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallback;
import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;

public class UserManager
{
	private static String selectedServer = "http://localhost:9722/api/custom";
	
	private static final String CREATE = "create";
	
	public static void setServer(String server)
	{
		selectedServer = server;
	}

	public static void createUser(String username, String password, final EcCallback success, final EcCallback failure)
	{
		Map<String, String> data = JSCollections.$map(
			"userId", username, 
			"password", password
		);
		
		FormData fd = new FormData();
		fd.append("user", JSGlobal.JSON.stringify(data));
		
		EcRemote.postExpectingObject(selectedServer, CREATE, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				success.callback(object);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				failure.callback(p1);				
			}
		});
	}
}
