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

}
