package com.eduworks.ec.service.task;

import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.service.task.model.TaskList;


public class TaskListManager {
	
	private static String selectedServer = "http://localhost:9722/api/custom/taskList";
	
	private static final String READ = "read";
	
	public static void readTaskList(Callback1<Object> success, Callback1<String> fail)
	{
		EcRemote.postExpectingObject(selectedServer, READ, null, success, fail);
	}
	
}
