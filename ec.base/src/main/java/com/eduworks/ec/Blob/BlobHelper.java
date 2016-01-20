package com.eduworks.ec.Blob;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

@GlobalScope
@STJSBridge(sources = { "blobHelper.js" })
public class BlobHelper
{
	public static Object base64ToBlob(String base64, String contentType){return null;}
}
