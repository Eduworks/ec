package org.cassproject.ebac.identity.remote;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;
import org.stjs.javascript.jquery.Promise;

/**
 * Created by fray on 5/9/17.
 */

@STJSBridge()
@GlobalScope
public class hello
{
	public static Promise init(Object o){return null;}
	public static Promise login(String network,Object options){return null;}
	public static Promise logout(String network,Object options){return null;}
	public static Boolean getAuthReponse(String network){return null;}
	public static Promise api(String network, String api, String method,Object parameters) {return null;}

}

