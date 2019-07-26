package org.cassproject.ebac.identity.remote;

import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.jquery.Promise;

/**
 * Created by fray on 5/9/17.
 */

@STJSBridge()
public class hello {
	public static void init(Object o) {
	}

	public static Promise login(String network, Object options) {
		return null;
	}

	public static Promise logout(String network, Object options) {
		return null;
	}

	public static Boolean getAuthResponse(String network) {
		return null;
	}

	public static Promise api(String api, String method, Object parameters) {
		return null;
	}

	public static void on(String s, Callback1<Object> callback1) {
	}
}

