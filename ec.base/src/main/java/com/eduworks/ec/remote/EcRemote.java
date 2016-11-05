package com.eduworks.ec.remote;

import static org.stjs.javascript.JSGlobal.JSON;
import static org.stjs.javascript.jquery.GlobalJQuery.$;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback3;
import org.stjs.javascript.jquery.AjaxParams;
import org.stjs.javascript.jquery.JQueryXHR;

/**
 * Wrapper to handle all remote web service invocations.
 * @class EcRemote
 * @module com.eduworks.ec
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 *
 */
public class EcRemote
{
	/**
	 * Turn this property off to cause all remote web service calls to be synchronous. Can be useful for test scripts, blocking calls, etc.
	 * @property async
	 * @static
	 * @type boolean
	 */
	public static boolean async = true;

	/**
	 * POSTs a request to a remote endpoint. 
	 * Composed of a server endpoint (root URL) and a service (service path).
	 * Sends form data as a multi-part mime request.
	 * @method postExpectingObject
	 * @static
	 * @param {string} server Protocol, hostname and path to the remote handler.
	 * @param {string} service Path to service to invoke.
	 * @param {FormData} fd Form data to send as multi-part mime.
	 * @param {function(object)} success Method that is invoked if the server responds with a success (per jQuery ajax)
	 * @param {function(string)} failure Method that is invoked if the server responds with an error (per jQuery ajax) or a non-200/300.
	 */
	public static void postExpectingObject(String server, String service, FormData fd, final Callback1<Object> success, final Callback1<String> failure)
	{
		postInner(server, service, fd, getSuccessJSONCallback(success, failure), getFailureCallback(failure));
	}

	/**
	 * POSTs a request to a remote endpoint. 
	 * Composed of a server endpoint (root URL) and a service (service path).
	 * Sends form data as a multi-part mime request.
	 * @method postExpectingString
	 * @static
	 * @param {string} server Protocol, hostname and path to the remote handler.
	 * @param {string} service Path to service to invoke.
	 * @param {FormData} fd Form data to send as multi-part mime.
	 * @param {function(string)} success Method that is invoked if the server responds with a success (per jQuery ajax)
	 * @param {function(string)} failure Method that is invoked if the server responds with an error (per jQuery ajax) or a non-200/300.
	 */
	public static void postExpectingString(String server, String service, FormData fd, final Callback1<String> success, final Callback1<String> failure)
	{
		postInner(server, service, fd, getSuccessCallback(success, failure), getFailureCallback(failure));
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

		// Node JS serialization check.
		if (JSObjectAdapter.$get(fd, "_streams") != null)
		{
			// We're in node. Serialize the 'form-data' object by hand.
			Array<String> chunks = (Array<String>) JSObjectAdapter.$get(fd, "_streams");
			String all = "";
			for (int i = 0; i < chunks.$length(); i++)
			{
				if (JSGlobal.typeof(chunks.$get(i)) == "function")
					all = all + "\r\n";
				else
					all = all + chunks.$get(i);
			}
			all = all + "\r\n" + "\r\n" + "--" + JSObjectAdapter.$get(fd, "_boundary") + "--";
			p.headers = (Map<String, String>) new Object();
			p.headers.$put("Content-Type", "multipart/form-data; boundary=" + JSObjectAdapter.$get(fd, "_boundary"));
			p.data = all;
		} else
		{
			// We're in a browser.
			p.mimeType = "multipart/form-data";
			p.data = fd;
		}
		JSObjectAdapter.$properties(p).$put("contentType", false);

		p.cache = false;
		p.async = async;
		p.processData = false;

		p.success = successCallback;
		p.error = failureCallback;

		upgradeHttpToHttps(p);
		$.ajax(p);
	}

	/**
	 * GETs something from a remote endpoint. 
	 * Composed of a server endpoint (root URL) and a service (service path).
	 * @method postExpectingString
	 * @static
	 * @param {string} server Protocol, hostname and path to the remote handler.
	 * @param {string} service Path to service to invoke.
	 * @param {function(object)} success Method that is invoked if the server responds with a success (per jQuery ajax)
	 * @param {function(string)} failure Method that is invoked if the server responds with an error (per jQuery ajax) or a non-200/300.
	 */
	public static void getExpectingObject(String server, String service, final Callback1<Object> success, final Callback1<String> failure)
	{
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

		p.dataType = "json";

		p.success = getSuccessJSONCallback(success, failure);
		p.error = getFailureCallback(failure);

		upgradeHttpToHttps(p);
		$.ajax(p);
	}

	/**
	 * DELETEs something at a remote endpoint. 
	 * Composed of a server endpoint (root URL) and a service (service path).
	 * @method _delete
	 * @static
	 * @param {string} server Protocol, hostname and path to the remote handler.
	 * @param {string} service Path to service to invoke.
	 * @param {function(object)} success Method that is invoked if the server responds with a success (per jQuery ajax)
	 * @param {function(string)} failure Method that is invoked if the server responds with an error (per jQuery ajax) or a non-200/300.
	 */
	public static void _delete(String url, String signatureSheet, final Callback1<String> success, final Callback1<String> failure)
	{
		AjaxParams p = new AjaxParams();
		p.method = "DELETE";
		p.url = url;
		p.async = async;
		p.headers = (Map<String, String>) new Object();
		p.headers.$put("signatureSheet", signatureSheet);

		p.success = getSuccessCallback(success, failure);
		p.error = getFailureCallback(failure);

		upgradeHttpToHttps(p);
		$.ajax(p);
	}

	protected static void upgradeHttpToHttps(AjaxParams p)
	{
		// Upgrade protocol to avoid mixed active content
		if (Global.window != null)
			if (Global.window.location != null)
				if (p.url.indexOf(Global.window.location.protocol) == -1)
					if (Global.window.location.protocol.startsWith("https"))
						if (!p.url.startsWith("https:"))
							p.url = p.url.replace("http:", "https:");
	}

	protected static void handleFailure(final Callback1<String> failure, JQueryXHR paramP1, String paramP2, String paramP3)
	{
		if (failure != null)
			if (paramP1 != null)
				if (paramP1.responseText != null)
					failure.$invoke(paramP1.responseText);
				else if (paramP1.statusText != null)
					failure.$invoke(paramP1.statusText.toString());
				else
					failure.$invoke("General error in AJAX request.");
			else if (paramP2 != null)
				failure.$invoke(paramP2);
			else if (paramP3 != null)
				failure.$invoke(paramP2);
			else
				failure.$invoke("General error in AJAX request.");
	}

	protected static Callback3<Object, String, JQueryXHR> getSuccessCallback(final Callback1<String> success, final Callback1<String> failure)
	{
		return new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (arg2.status > 300 || arg2.status < 200)
					failure.$invoke("Error with code: " + arg2.status);
				else if (success != null)
					success.$invoke(arg2.responseText);
			}
		};
	}

	protected static Callback3<Object, String, JQueryXHR> getSuccessJSONCallback(final Callback1<Object> success, final Callback1<String> failure)
	{
		return new Callback3<Object, String, JQueryXHR>()
		{
			@Override
			public void $invoke(Object arg0, String arg1, JQueryXHR arg2)
			{
				if (arg2.status > 300 || arg2.status < 200)
					failure.$invoke("Error with code: " + arg2.status);
				else if (success != null)
					success.$invoke(JSON.parse(arg2.responseText));
			}
		};
	}

	protected static Callback3<JQueryXHR, String, String> getFailureCallback(final Callback1<String> failure)
	{
		return new Callback3<JQueryXHR, String, String>()
		{
			@Override
			public void $invoke(JQueryXHR paramP1, String paramP2, String paramP3)
			{
				handleFailure(failure, paramP1, paramP2, paramP3);
			}
		};
	}

}
