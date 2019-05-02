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
	 * @memberOf EcArray
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
	 * @memberOf EcArray
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
	 * @memberOf EcArray
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
	 * @memberOf EcArray
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
	 * @memberOf EcArray
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
	 * @memberOf EcArray
	 */
	public static boolean isObject(Object o) {
		if (isArray(o))
			return false;
		if (o == null)
			return false;
		return JSGlobal.typeof(o) == "object";
	}

	/**
	 * Returns the index of an object or value if the object or value exists in the array. Uses .equals if available.
	 * @param {Array} a Array to check over.
	 * @param {any} o Object to check for.
	 * @return Index of the result, -1 if the result isn't in the array.
	 * @static
	 * @method indexOf
	 * @memberOf EcArray
	 */
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
