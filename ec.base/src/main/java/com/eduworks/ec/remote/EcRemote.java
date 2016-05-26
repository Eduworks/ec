package com.eduworks.ec.remote;

import static org.stjs.javascript.JSGlobal.JSON;
import static org.stjs.javascript.jquery.GlobalJQuery.$;

import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.Window;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback3;
import org.stjs.javascript.jquery.AjaxParams;
import org.stjs.javascript.jquery.JQueryXHR;

public class EcRemote
{
	public static boolean async = true;
	
	public static void postExpectingObject(String server, String service, FormData fd, final Callback1<Object> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(JSON.parse(arg2.responseText));
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP1.responseText);
			}
		};

		postInner(server, service,fd, successCallback, failureCallback);
	}

	public static void postExpectingString(String server, String service, FormData fd, final Callback1<String> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(arg2.responseText);
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP1.responseText);
			}
		};

		postInner(server, service, fd,successCallback, failureCallback);
	}

	private static void postInner(String server, String service, FormData fd, Callback3<Object, String, JQueryXHR> successCallback,
			Callback3<JQueryXHR, String, String> failureCallback)
	{
		String url = server;
		if (!url.endsWith("/") && service != null && !"".equals(service))
			url += "/";
		if (service != null)
			url += service;

		AjaxParams p = new AjaxParams();
		p.method = "POST";
		p.url = url;
		p.mimeType = "multipart/form-data";
		p.data = fd;
		JSObjectAdapter.$properties(p).$put("contentType", false);

		p.cache = false;
		p.async = async;
		p.processData = false;

		p.success = successCallback;
		p.error = failureCallback;

		//Upgrade protocol to avoid mixed active content
		if (p.url.indexOf(Global.window.location.protocol) == -1)
			if (!p.url.startsWith("https"))
				p.url = p.url.replace("http", "https");
		$.ajax(p);
	}

	public static void getExpectingObject(String server, String service, final Callback1<Object> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(JSON.parse(arg2.responseText));
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP1.responseText);
			}
		};

		String url = server;
		if (!url.endsWith("/") && service != null && service.equals(""))
			url += "/";
		if (service != null)
			url += service;

		AjaxParams p = new AjaxParams();
		p.method = "GET";
		p.url = url;
		p.cache = false;
		p.async = async;
		p.processData = false;

		p.success = successCallback;
		p.error = failureCallback;

		//Upgrade protocol to avoid mixed active content
		if (p.url.indexOf(Global.window.location.protocol) == -1)
			if (!p.url.startsWith("https"))
			p.url = p.url.replace("http", "https");
		$.ajax(p);
	}
	public static void _delete(String url, String signatureSheet, final Callback1<String> success, final Callback1<String> failure)
	{
		Callback3<Object, String, JQueryXHR> successCallback = new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (success != null)
					success.$invoke(arg2.responseText);
			}
		};

		Callback3<JQueryXHR, String, String> failureCallback = new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				if (failure != null)
					failure.$invoke(paramP1.responseText);
			}
		};

		AjaxParams p = new AjaxParams();
		p.method = "DELETE";
		p.url = url;
		p.async = async;
		p.headers = (Map<String,String>)new Object();
		p.headers.$put("signatureSheet", signatureSheet);

		p.success = successCallback;
		p.error = failureCallback;

		//Upgrade protocol to avoid mixed active content
		if (p.url.indexOf(Global.window.location.protocol) == -1)
			if (!p.url.startsWith("https"))
			p.url = p.url.replace("http", "https");
		$.ajax(p);
	}

}
