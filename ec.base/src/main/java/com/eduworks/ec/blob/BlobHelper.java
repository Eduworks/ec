package com.eduworks.ec.blob;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.dom.File;

@GlobalScope
@STJSBridge(sources = {"blobHelper.js"})
public class BlobHelper {
	public static Object base64ToBlob(String base64, String contentType) {
		return null;
	}

	public static File stringToFile(Object text, String name, String contentType) {
		return null;
	}

	public static String ab2str(ArrayBuffer ab) {
		return null;
	}

	public static ArrayBuffer str2ab(String ab) {
		return null;
	}
}
