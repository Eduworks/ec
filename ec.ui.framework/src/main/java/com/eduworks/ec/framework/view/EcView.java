package com.eduworks.ec.framework.view;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.JSStringAdapter;
import org.stjs.javascript.Map;

/**
 * Class that represents a "view" that can be displayed in an container element on the page. The View should define 
 * a display function that loads HTML into the container element on the page and then finally calls the callback once
 * the view has been completely initialized
 * 
 * @module com.eduworks.ec.ui
 * @class EcView
 * @author devlin.junker@eduworks.com
 *
 */
public abstract class EcView
{

	/**
	 * Function to be defined in subclasses that returns the location of the main html file associated with this view
	 * 
	 * @memberOf EcView
	 * @method getHtmlLocation
	 * @abstract
	 * @return {String}
	 * 			The string path to an html file
	 */
	public abstract String getHtmlLocation();

	/**
	 * Display function to override (usually in JavaScript) that will set up any event handlers
	 * 
	 * @memberOf EcView
	 * @method display
	 * @param {String} containerId
	 */
	public void display(String containerId)
	{
		Global.console.error("Not Implemented");
	}

	/***
	 * Function that will convert a view to a certain other view class as long as it the converted type inherits the
	 * current type of the view
	 * 
	 * @memberOf EcView
	 * @method as
	 * @param {Class} _interface
	 * 			Class type that the instance should be converted to
	 * @return {Object}
	 * 			The converted instance of the type passed in
	 */
	public <T> T as(Class<T> _interface)
	{
		Object prototype = JSObjectAdapter.$get(this, "__proto__");
		Object constructor = JSObjectAdapter.$get(prototype, "constructor");
		Array inherits = (Array) JSObjectAdapter.$get(constructor, "$inherit");

		if (inherits != null)
			for (int i = 0; i < inherits.$length(); i++)
			{
				if (inherits.$get(i) == _interface)
				{
					return (T) this;
				}
			}

		return null;
	}

	/**
	 * Returns the URL parameters of the browser window
	 * 
	 * @memberOf EcView
	 * @method getUrlParameters
	 * @return {Map<String, String>}
	 * 			URL Parameters in a map
	 */
	public Object getUrlParameters()
	{
		return EcView.urlParameters();
	}

	/**
	 * Returns the URL Query parameters of the browser window
	 * 
	 * @memberOf EcView
	 * @method urlParameters
	 * @static
	 * @return {Map<String, String>}
	 * 			URL Query Parameters in a map
	 */
	public static Object queryParams(){
		if (Global.window.document.location.search == null)
			return new Object();
		Array<String> hashSplit = JSCollections.$castArray(Global.window.document.location.search.split("?"));

		if (hashSplit.$length() > 1)
		{
			Object o = null;
			Map<String, Object> params = JSObjectAdapter.$properties(o = new Object());
			String paramString = hashSplit.$get(1);
			Array<String> parts = JSStringAdapter.split(paramString, "&");
			for (int i = 0; i < parts.$length(); i++)
				params.$put(parts.$get(i).split("=")[0], parts.$get(i).replace(parts.$get(i).split("=")[0] + "=", ""));
			return o;
		}
		return new Object();
	}
	
	/**
	 * Returns the URL Hash parameters of the browser window
	 * 
	 * @memberOf EcView
	 * @method urlParameters
	 * @static
	 * @return {Map<String, String>}
	 * 			URL Hash Parameters in a map
	 */
	public static Object hashParams(){
		if (Global.window.document.location.hash == null)
			return new Object();
		Array<String> hashSplit = JSCollections.$castArray(Global.window.document.location.hash.split("?"));

		if (hashSplit.$length() > 1)
		{
			Object o = null;
			Map<String, Object> params = JSObjectAdapter.$properties(o = new Object());
			String paramString = hashSplit.$get(1);
			Array<String> parts = JSStringAdapter.split(paramString, "&");
			for (int i = 0; i < parts.$length(); i++)
				params.$put(parts.$get(i).split("=")[0], parts.$get(i).replace(parts.$get(i).split("=")[0] + "=", ""));
			return o;
		}
		return new Object();
		
	}
	
	/**
	 * Returns the URL parameters of the browser window
	 * 
	 * @memberOf EcView
	 * @method urlParameters
	 * @static
	 * @return {Map<String, String>}
	 * 			URL Parameters in a map
	 */
	public static Object urlParameters()
	{
		Object params = hashParams();
		
		Object queryParams = queryParams();
		
		for(String key : JSObjectAdapter.$properties(queryParams)) 
		{
			JSObjectAdapter.$put(params, key, JSObjectAdapter.$get(queryParams, key));
		}
		
		return params;
	}

}
