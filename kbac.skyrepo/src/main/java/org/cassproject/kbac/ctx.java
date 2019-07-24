package org.cassproject.kbac;

import org.stjs.javascript.annotation.Namespace;
import org.stjs.javascript.annotation.STJSBridge;

@Namespace("this")
@STJSBridge
public class ctx
{
	public static void put(String s,Object o){};
	public static Object get(String s){return null;}
}
