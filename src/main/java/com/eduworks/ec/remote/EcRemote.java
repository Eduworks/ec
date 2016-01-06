package com.eduworks.ec.remote;

import static org.stjs.javascript.JSGlobal.JSON;
import static org.stjs.javascript.jquery.GlobalJQuery.$;

import org.stjs.javascript.functions.Callback3;
import org.stjs.javascript.jquery.AjaxParams;
import org.stjs.javascript.jquery.JQueryXHR;

import com.eduworks.ec.callback.EcCallback;

public class EcRemote
{
	public static void httpPost(String service, Object c, final EcCallback success, final EcCallback failure)
	{
		String url = EcRemoteConfig.serviceUrl;
		if (!url.endsWith("/"))
			url += "/";
		url += service;
		
		AjaxParams p = new AjaxParams();
		p.url = url;

		Callback3<Object, String, JQueryXHR> successListener = new Callback3<Object, String, JQueryXHR>(){
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				success.callback(JSON.parse(arg2.responseText));
			}
		};
			
		p.success = successListener;

		Callback3<JQueryXHR, String, String> failureListener = new Callback3<JQueryXHR, String, String>(){

			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				failure.callback(paramP1.status);
			}
		};
			
		p.error = failureListener;
		
		$.ajax(p);
		
	}

}
