package org.cass.imports;

import com.eduworks.ec.array.toString;

public abstract class Importer {
	public static boolean isObject(Object obj)
	{
		return toString.call(obj) == "[object Object]";
	}
	
	public static boolean isArray(Object obj)
	{
		return toString.call(obj) == "[object Array]";
	}
}
