package com.eduworks.ec.array;

import org.stjs.javascript.JSGlobal;

/**
 * Object Helper Functions
 * @class EcObject
 * @author fritz.ray@eduworks.com
 */
public class EcObject
{
	/**
	 * Returns true if the result is an object.
	 * @static
	 * @method isArray
	 * @param {any} o Object to test.
	 * @return true iff the object is an object.
	 */
	public static boolean isObject(Object o)
	{
		return JSGlobal.typeof(o) == "object";
	}
}
