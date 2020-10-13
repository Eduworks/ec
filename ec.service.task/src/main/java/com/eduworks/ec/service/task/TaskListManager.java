package com.eduworks.ec.service.task;

import com.eduworks.ec.remote.EcRemote;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;


public class TaskListManager {

	private static final String READ = "read";
	private static String selectedServer = "http://localhost:9722/api/taskList/";

	public static void readTaskList(Callback1<Object> success, Callback2<String, Integer> fail) {
		EcRemote.getExpectingObject(selectedServer, READ, success, fail);
	}

}
