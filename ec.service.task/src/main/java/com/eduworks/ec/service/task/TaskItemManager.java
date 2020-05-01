package com.eduworks.ec.service.task;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;


public class TaskItemManager {

	public static final String CREATE = "create";
	public static final String SET_COMPLETE = "complete";
	public static final String SET_INCOMPLETE = "incomplete";
	private static String selectedServer = "http://localhost:9722/api/task/";

	public static String getSelectedServer() {
		return selectedServer;
	}

	public static void setSelectedServer(String server) {
		selectedServer = server;
	}

	public static void setComplete(String taskId, Callback1<Object> success, Callback2<String, Integer> fail) {
		Map<String, String> data = JSCollections.$map(
				"taskId", taskId
		);

		FormData fd = new FormData();
		fd.append("task", JSGlobal.JSON.stringify(data));

		EcRemote.postExpectingObject(selectedServer, SET_COMPLETE, fd, success, fail);

	}

	public static void setIncomplete(String taskId, Callback1<Object> success, Callback2<String, Integer> fail) {
		Map<String, String> data = JSCollections.$map(
				"taskId", taskId
		);

		FormData fd = new FormData();
		fd.append("task", JSGlobal.JSON.stringify(data));

		EcRemote.postExpectingObject(selectedServer, SET_INCOMPLETE, fd, success, fail);
	}

	public static void create(String taskName, String dueDate, Callback1<Object> success, Callback2<String, Integer> fail) {
		Map<String, String> data = JSCollections.$map(
				"taskName", taskName,
				"taskDueDate", dueDate
		);

		FormData fd = new FormData();
		fd.append("task", JSGlobal.JSON.stringify(data));

		EcRemote.postExpectingObject(selectedServer, CREATE, fd, success, fail);
	}
}
