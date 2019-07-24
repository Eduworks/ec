package com.eduworks.ec.framework.browser.url;

import com.eduworks.ec.framework.view.manager.ScreenManager;
import org.stjs.javascript.*;

public class URLParams {

	/**
	 * Returns the URL Query parameters of the browser window
	 *
	 * @return {Map<String, String>}
	 * URL Query Parameters in a map
	 * @memberOf URLParams
	 * @method queryParams
	 * @static
	 */
	public static Map<String, String> queryParams() {
		if (Global.window.document.location.search == null)
			return JSCollections.$map();
		Array<String> hashSplit = JSCollections.$castArray(Global.window.document.location.search.split("?"));

		if (hashSplit.$length() > 1) {
			Map<String, String> o = JSCollections.$map();
			String paramString = hashSplit.$get(1);
			Array<String> parts = JSStringAdapter.split(paramString, "&");
			for (int i = 0; i < parts.$length(); i++)
				o.$put(parts.$get(i).split("=")[0], parts.$get(i).replace(parts.$get(i).split("=")[0] + "=", ""));
			return o;
		}
		return JSCollections.$map();
	}

	/**
	 * Returns the URL Hash parameters of the browser window
	 *
	 * @return {Map<String, String>}
	 * URL Hash Parameters in a map
	 * @memberOf EcView
	 * @method hashParams
	 * @static
	 */
	public static Map<String, String> hashParams() {
		if (Global.window.document.location.hash == null)
			return JSCollections.$map();
		Array<String> hashSplit = JSCollections.$castArray(Global.window.document.location.hash.split("?"));

		if (hashSplit.$length() > 1) {
			Map<String, String> o = JSCollections.$map();
			String paramString = hashSplit.$get(1);
			Array<String> parts = JSStringAdapter.split(paramString, "&");
			for (int i = 0; i < parts.$length(); i++)
				o.$put(parts.$get(i).split("=")[0], parts.$get(i).replace(parts.$get(i).split("=")[0] + "=", ""));
			return o;
		}
		return JSCollections.$map();

	}

	/**
	 * Returns the URL parameters of the browser window
	 *
	 * @return {Map<String, String>}
	 * URL Parameters in a map
	 * @memberOf URLParams
	 * @method getParams
	 * @static
	 */
	public static Map<String, String> getParams() {
		Map<String, String> params = hashParams();

		Map<String, String> queryParams = queryParams();

		for (String key : JSObjectAdapter.$properties(queryParams)) {
			JSObjectAdapter.$put(params, key, JSObjectAdapter.$get(queryParams, key));
		}

		return params;
	}

	/**
	 * Returns a specific URL parameter
	 *
	 * @param {String} paramName
	 *                 Name of URL parameter to retrieve
	 * @return {String}
	 * Value of URL parameter if it exists
	 * @memberOf URLParams
	 * @method get
	 * @static
	 */
	public static String get(String paramName) {
		return getParams().$get(paramName);
	}

	/**
	 * Sets a specific URL Parameter
	 *
	 * @param {String} paramName
	 *                 Name of URL parameter to set
	 * @param {String} val
	 *                 Value to set for URL parameter
	 * @memberOf URLParams
	 * @method set
	 * @static
	 */
	public static void set(String paramName, String val) {
		Map<String, String> params = getParams();

		params.$put(paramName, val);

		ScreenManager.setScreenParameters(params);
	}

	/**
	 * Sets a specific URL Parameter
	 *
	 * @param {Object} params
	 *                 Map of Strings to Strings for URL parameters
	 * @memberOf URLParams
	 * @method setAll
	 * @static
	 */
	public static void setAll(Object params) {
		ScreenManager.setScreenParameters(params);
	}
}
