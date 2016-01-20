package com.eduworks.ec.random;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

@GlobalScope
@STJSBridge(sources = { "random.js" })
public class EcRandom
{
	public static String generateUUID()
	{
		return null;
	}
}
