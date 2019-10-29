package org.cassproject.kbac;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("this")
@STJSBridge
public class params {
	public static String q;
	public static String urlRemainder;
	public static String start;
	public static String size;
	public static String sort;
	public static String track_scores;
	public static String index_hint;
	public static String id;
	public static String type;
	public static String version;
	public static String expand;
	public static String refresh;
	public static String methodType;
	public static Object obj;
}
