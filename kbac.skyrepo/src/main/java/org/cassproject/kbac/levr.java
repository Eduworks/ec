package org.cassproject.kbac;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function0;
import org.stjs.javascript.functions.Function1;

@GlobalScope
@STJSBridge()
public class levr {

	public static Function1 fileFromDatastream;

	public static Function0 headers;

	public static String fileToString(Object file) {
		return null;
	}

	public static void error(String message, Integer httpCode) {
	}

	public static Integer date(String input, String dateFormat, Boolean raw) {
		return null;
	}

	public static String urlEncode(String toEncode) {
		return null;
	}

	public static String httpPost(Object o, String url, String contentType, boolean multipart) {
		return null;
	}

	public static String httpDelete(String url) {
		return null;
	}

	public static String httpGet(String url) {
		return null;
	}

	public static Object httpPut(Object o, String url,String contentType) {
		return null;
	}

	public static String jsonLdToNQuads(Object o) {
		return null;
	}

	public static String jsonLdToRdfJson(Object o) {
		return null;
	}

	public static String jsonLdToRdfXml(Object o) {
		return null;
	}

	public static String jsonLdToTurtle(Object o) {
		return null;
	}

	public static Object jsonLdExpand(Object o) {
		return null;
	}

	public static Function0 beforeGet;

	public static Function0 afterSave;

	public static String rsaGenerate() {
		return null;
	}

	public static void fileSave(Object toSave, String path) {
	}

	public static boolean fileExists(String path) {
		return false;
	}

	public static Object fileLoad(String path) {
		return null;
	}

	public static void bindWebService(String endpoint, Function0 callback0) {
	}

	public static String randomString(int length) {
		return null;
	}
}