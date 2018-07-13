package com.eduworks.ec.array;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;

/**
 * Object Helper Functions
 *
 * @author fritz.ray@eduworks.com
 * @class EcObject
 * @module com.eduworks.ec
 */
public class EcObject {
	/**
	 * Returns true if the result is an object.
	 *
	 * @param {any} o Object to test.
	 * @return true iff the object is an object.
	 * @static
	 * @method isArray
	 */
	public static boolean isObject(Object o) {
		if (o == null)
			return false;
		return JSGlobal.typeof(o) == "object";
	}

	/**
	 * Returns keys on the object
	 *
	 * @param {any} o Object to test.
	 * @return List of keys
	 * @static
	 * @method keys
	 */
	public static Array<String> keys(Object o) {
		return EcJsObject.ecKeys(o);
	}
}
