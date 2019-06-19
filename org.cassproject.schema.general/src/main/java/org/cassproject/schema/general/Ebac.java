package org.cassproject.schema.general;

/**
 * Location of strings that store the current namespace for EBAC/KBAC.
 *
 * @author fritz.ray@eduworks.com
 * @class Ebac
 * @module org.cassproject
 */
public class Ebac {
	public static String context_0_1 = "http://schema.eduworks.com/ebac/0.1";
	public static String context_0_2 = "http://schema.eduworks.com/ebac/0.2";
	public static String context_0_3 = "http://schema.cassproject.org/kbac/0.2";
	public static String context_0_4 = "https://schema.cassproject.org/kbac/0.4";
	/**
	 * Current version of KBAC.
	 *
	 * @property context
	 * @static
	 * @type string (URL)
	 */
	public static String context = context_0_4;
}
