package com.eduworks.ec.service.user;

import com.eduworks.ec.remote.EcRemote;
import com.eduworks.ec.remote.FormData;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class UserManager {
	private static final String CREATE = "create";
	private static String selectedServer = "http://localhost:9722/api";

	public static void setServer(String server) {
		selectedServer = server;
	}

	public static void createUser(String username, String password, final Callback1<Object> success, final Callback2<String, Integer> fail) {
		Map<String, String> data = JSCollections.$map(
				"userId", username,
				"password", password
		);

		FormData fd = new FormData();
		fd.append("user", JSGlobal.JSON.stringify(data));

		EcRemote.postExpectingObject(selectedServer, CREATE, fd, success, fail);
	}
}
