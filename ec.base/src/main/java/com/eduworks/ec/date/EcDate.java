package com.eduworks.ec.date;

import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Function0;

public class EcDate {
	public static String toISOString(Date obj) {
		return (String) ((Function0) JSObjectAdapter.$get(obj, "toISOString")).$invoke();
	}
}
