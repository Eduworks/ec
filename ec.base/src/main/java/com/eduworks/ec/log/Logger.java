package com.eduworks.ec.log;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

/**
 * Created by fray on 8/10/17.
 */
@GlobalScope
@STJSBridge
public class Logger {
	public static void log(String s) {
		Logger.ecLog(s);
	}

	public static void ecLog(String s) {
		//Not implemented here. Look in JS.
	}

}
