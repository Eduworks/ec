package org.cassproject.kbac;

import org.cassproject.ebac.repository.EcRepository;
import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.functions.Function0;
import org.stjs.javascript.functions.Function1;

@GlobalScope
@STJSBridge()
public class levr {

	public static EcRepository repo;

	public static Function1 fileFromDatastream;

	public static Function0 headers;

	public static String fileToString(Object file) {
		return null;
	}

	public static String stringToHex(String string) {
		return null;
	}

	public static String md5(String message){return null;}

	public static void error(String message, Integer httpCode) {
	}

	public static void debug(String message) {
	}

	public static Integer date(String input, String dateFormat, Boolean raw) {
		return null;
	}

	public static String urlEncode(String toEncode) {
		return null;
	}

	public static String httpPost(Object o, String url, String contentType, boolean multipart,String name, String authToken, Boolean reliable) {
		return null;
	}

	public static String httpDelete(String url, String authToken, Boolean reliable) {
		return null;
	}

	public static String httpGet(String url,Boolean reliable) {
		return null;
	}

	public static Object httpPut(Object o, String url,String contentType, String authToken, Boolean reliable) {
		return null;
	}

	public static Function0 forEach;//(Object obj, String paramName, String valueName, Object resolvable, Boolean outputAsArray, Boolean threaded, Boolean saveMemory, Boolean soft, Boolean rethrow){return null;}

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
	public static Function0 afterSaveBulk;

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