package com.eduworks.ec.array;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;

/**
 * Array Helper Functions
 *
 * @author fritz.ray@eduworks.com
 * @class EcArray
 * @module com.eduworks.ec
 */
public class EcArray {
	/**
	 * Returns true if the result is an array.
	 *
	 * @param {any} o Object to test.
	 * @return true iff the object is an array.
	 * @static
	 * @method isArray
	 */
	public static boolean isArray(Object o) {
		return toString.call(o) == "[object Array]";
	}

	/**
	 * Removes values IFF the values == one another.
	 *
	 * @param a {Array} Array to remove duplicates from.
	 * @static
	 * @method removeDuplicates
	 */
	public static void removeDuplicates(Array a) {
		for (int i = 0; i < a.$length(); i++)
			for (int j = i; j < a.$length(); j++) {
				if (j == i)
					continue;
				if (a.$get(i) == a.$get(j))
					a.splice(j, 1);
			}
	}

	/**
	 * Adds a value if the array does not have the value already.
	 *
	 * @param a {Array} Array to add to.
	 * @param o {Object} Object to add to the array if it isn't in there already.
	 * @static
	 * @method setAdd
	 */
	public static void setAdd(Array a, Object o) {
		if (!has(a,o)) a.push(o);
	}

	/**
	 * Removes a value from the array.
	 *
	 * @param a {Array} Array to add to.
	 * @param o {Object} Object to add to the array if it isn't in there already.
	 * @static
	 * @method setAdd
	 */
	public static void setRemove(Array a, Object o) {
		while (has(a,o))
			a.splice(indexOf(a,o),1);
	}

	/**
	 * Returns true if the array has the value already.
	 *
	 * @param a {Array} Array.
	 * @param o {Object} Object to sample for.
	 * @static
	 * @method has
	 */
	public static boolean has(Array a, Object o) {
		if (isObject(o))
			for (int i = 0; i < a.$length(); i++) {
				if (a.$get(i) == o)
					return true;
				try {
					if (a.$get(i).equals(o))
						return true;
				} catch (Exception e) {
				}
			}
		else for (int i = 0; i < a.$length(); i++) {
			if (a.$get(i) == o) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if the result is an object.
	 *
	 * @param {any} o Object to test.
	 * @return true iff the object is an object.
	 * @static
	 * @method isObject
	 */
	public static boolean isObject(Object o) {
		if (isArray(o))
			return false;
		if (o == null)
			return false;
		return JSGlobal.typeof(o) == "object";
	}

	public static int indexOf(Array a, Object o) {
		if (isObject(o))
			for (int i = 0; i < a.$length(); i++) {
				if (a.$get(i) == o)
					return i;
				try {
					if (a.$get(i).equals(o))
						return i;
				} catch (Exception e) {
				}
			}
		else for (int i = 0; i < a.$length(); i++) {
			if (a.$get(i) == o) {
				return i;
			}
		}
		return -1;
	}
}
