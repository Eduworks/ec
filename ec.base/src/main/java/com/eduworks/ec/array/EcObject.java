package com.eduworks.ec.array;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;

/**
 * Object Helper Functions
 * @class EcObject
 * @module com.eduworks.ec
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
	/**
	 * Returns keys on the object
	 * @static
	 * @method keys
	 * @param {any} o Object to test.
	 * @return List of keys
	 */
	public static Array<String> keys(Object o)
	{
		return EcJsObject.ecKeys(o);
	}
}
