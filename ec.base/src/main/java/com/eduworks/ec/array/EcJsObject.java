package com.eduworks.ec.array;

import org.stjs.javascript.Array;
import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

@GlobalScope
@STJSBridge(sources = {"blobHelper.js"})
public class EcJsObject {
	public static Array<String> ecKeys(Object o) {
		return null;
	}
}
