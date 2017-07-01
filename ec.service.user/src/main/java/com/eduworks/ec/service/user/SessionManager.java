package com.eduworks.ec.service.user;

import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import com.eduworks.ec.service.user.model.EcLoginCredentials;
import com.eduworks.ec.service.user.model.User;

/**
 * Manages the Current User and SessionId information, stores the sessionId in the browser session storage
 * for now (we could change this or try setting it on startup later). 
 * @author djunker
 *
 */
public class SessionManager
{
	private static String selectedServer = "http://localhost:9722/api";
	
	private static final String LOGIN = "login";

	private static String sessionId = "";
	private static boolean isLoggedIn = false;
	
	private static User currentUser = null;
	
	static{
		sessionId = (String) Global.sessionStorage.$get("ecSessionId");
		
		String userObj = (String) Global.sessionStorage.$get("currentUser");
		
		if(userObj != null && sessionId != null)
		{
			isLoggedIn = true;
			currentUser = User._parse(JSGlobal.JSON.parse(userObj));
		}
			
	}
	
	public static void setServer(String server)
	{
		selectedServer = server;
	}
	
	public static String getSessionId()
	{
		if(sessionId == null){
			sessionId = (String) Global.sessionStorage.$get("ecSessionId");
		}
		return sessionId;
	}
	private static void setSessionId(String id)
	{
		sessionId = id;
		Global.sessionStorage.$put("ecSessionId", sessionId);
		
	}
	public static void clearSessionId(){
		Global.sessionStorage.$delete("ecSessionId");
	}
	
	public static boolean getLoggedIn()
	{
		return isLoggedIn;
	}
	
	public static User getCurrentUser(){
		if(currentUser == null){
			String userObj = (String) Global.sessionStorage.$get("currentUser");
			if(userObj != null)
				currentUser = User._parse(JSGlobal.JSON.parse(userObj));
		}
		
		return currentUser;
	}
	public static void setCurrentUser(User user)
	{
		currentUser = user;
		Global.sessionStorage.$put("currentUser", JSGlobal.JSON.stringify(currentUser));
	}
	public static void clearCurrentUser(){
		currentUser = null;
		Global.sessionStorage.$delete("currentUser");
	}

	public static void login(String username, String password, final Callback1<Object> success, final Callback1<String> fail)
	{
		EcLoginCredentials c = new EcLoginCredentials(username, password);
		FormData fd = new FormData();
		fd.append("user", JSGlobal.JSON.stringify(c));
		EcRemote.postExpectingObject(selectedServer,LOGIN, fd, new Callback1<Object>()
		{
			@Override
			public void $invoke(Object object)
			{
				setSessionId((String) JSObjectAdapter.$properties(object).$get("sessionId"));
				setCurrentUser(User._parse(object));
				isLoggedIn = true;
				
				if(success != null)
					success.$invoke(object);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				clearSessionId();
				clearCurrentUser();
				isLoggedIn = false;
				
				if(fail != null)
					fail.$invoke(p1);
			}
		});
	}
	
	public static void logout(Callback1<Object> success, Callback1<String> fail){
		clearCurrentUser();
		
		if(success != null)
			success.$invoke(null);
	}
}
