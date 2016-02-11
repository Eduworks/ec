package com.eduworks.ec.service.user.model;

import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.service.user.UserManager;
import com.eduworks.ec.service.user.display.UserInterface;

import static org.stjs.javascript.Global.parseInt;

public class User {
	private String userId;
	
	private Date lastLogin;
	private String lastIp;
	
	public User(String id, String loginDate, String ip){
		userId = id;
		
		lastLogin = new Date(parseInt(loginDate));
		
		lastIp = ip;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public Date getLastLogin()
	{
		return lastLogin;
	}
	
	public String getLastIp()
	{
		return lastIp;
	}
	
	public static User _parse(Object obj)
	{
		if(obj == null)
			return null;
		
		String userId, loginDate, lastIp;
		
		userId = (String) JSObjectAdapter.$get(obj, "userId");
		loginDate = (String) JSObjectAdapter.$get(obj, "lastLogin");
		lastIp = (String) JSObjectAdapter.$get(obj, "lastIp");
		
		return new User(userId, loginDate, lastIp);
	}
	
	
	public static void createUser(String username, String password, final UserInterface view)
	{
		UserManager.createUser(username, password, new Callback1<Object>() {
			
			@Override
			public void $invoke(Object p1) {
				view.createUserSuccess();
			}
		}, new Callback1<String>() {

			@Override
			public void $invoke(String p1) {
				view.createUserFailure();
			}
		});
	}
}
