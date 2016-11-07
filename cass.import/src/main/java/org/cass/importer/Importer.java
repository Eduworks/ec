package org.cass.importer;

import com.eduworks.ec.array.toString;

/**
 * Base class for all importers, can hold helper functions 
 * that are useful for all importers
 * 
 * @module org.cassproject
 * @class Importer
 * @abstract
 * @author devlin.junker@eduworks.com
 */
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
