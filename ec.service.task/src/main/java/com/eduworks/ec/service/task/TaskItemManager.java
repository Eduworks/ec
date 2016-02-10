package com.eduworks.ec.service.task;


public class TaskItemManager {

	private static String selectedServer = "http://localhost:9722/api/custom/task";
	
	public static final String CREATE = "create";
	
	public static final String SET_COMPLETE = "complete";
	public static final String SET_INCOMPLETE = "incomplete";
	
	public static void setSelectedServer(String server){
		selectedServer = server;
	}
	public static String getSelectedServer(){
		return selectedServer;
	}

}
