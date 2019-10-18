package com.eduworks.ec.date;

import org.stjs.javascript.Date;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Function0;

public class EcDate {
	/***
	 * Returns an ISO 8601 TimeDate String from a Date object.
	 * @param {Date} obj Date Object
	 * @memberOf EcDate
	 * @static
	 * @return
	 */
	public static String toISOString(Date obj) {
		return (String) ((Function0) JSObjectAdapter.$get(obj, "toISOString")).$invoke();
	}
}
