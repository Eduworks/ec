package com.eduworks.ec.array;

import org.stjs.javascript.Array;

/**
 * Array Helper Functions
 * @class EcArray
 * @author fritz.ray@eduworks.com
 */
public class EcArray
{
	/**
	 * Returns true if the result is an array.
	 * @static
	 * @method isArray
	 * @param {any} o Object to test.
	 * @return true iff the object is an array.
	 */
	public static boolean isArray(Object o)
	{
		return toString.call(o) == "[object Array]";
	}

	/**
	 * Removes values IFF the values == one another.
	 * @static
	 * @method removeDuplicates
	 * @param a {Array} Array to remove duplicates from.
	 */
	public static void removeDuplicates(Array a)
	{
		for (int i = 0; i < a.$length(); i++)
			for (int j = i; j < a.$length(); j++)
			{
				if (j == i)
					continue;
				if (a.$get(i) == a.$get(j))
					a.splice(j, 1);
			}
	}
}
