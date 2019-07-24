package org.cass.importer;

import com.eduworks.ec.array.toString;

/**
 * Base class for all importers, can hold helper functions
 * that are useful for all importers
 *
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class Importer
 * @abstract
 */
public abstract class Importer {
	public static boolean isObject(Object obj) {
		return toString.call(obj) == "[object Object]";
	}

	public static boolean isArray(Object obj) {
		return toString.call(obj) == "[object Array]";
	}
}
