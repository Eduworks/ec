package com.eduworks.ec.array;

import org.stjs.javascript.JSGlobal;

public class EcObject
{

	public static boolean isObject(Object o)
	{
		return JSGlobal.typeof(o)=="object";
	}
}
