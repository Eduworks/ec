package com.eduworks.ec.framework.view;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback0;

/**
 * Class that represents a "view" that can be displayed in an container element on the page. The View should define 
 * a display function that loads HTML into the container element on the page and then finally calls the callback once
 * the view has been completely initialized
 * 
 * @author devlin.junker@eduworks.com
 *
 */
public abstract class EcView {
	
	/**
	 * Display function to override (usually in JavaScript) that will load the HTML into the container and then call
	 * the callback passed in
	 *  
	 * @param containerId
	 * 			ID of the DOM element to load the View's HTML into
	 * @param callback
	 * 			Function to invoke after the HTML has been loaded and the view is initalized
	 */
	public abstract void display(String containerId, Callback0 callback);
	
	
	/**
	 * Function that will convert a view to a certain other view class as long as it the converted type inherits the
	 * current type of the view
	 * 
	 * @param _interface
	 * 			Class type that the instance should be converted to
	 * @return
	 * 			The converted instance of the type passed in
	 */
	public <T> T as(Class<T> _interface){
		Object prototype = JSObjectAdapter.$get(this, "__proto__");
		Object constructor = JSObjectAdapter.$get(prototype, "constructor");
		Array inherits = (Array)JSObjectAdapter.$get(constructor, "$inherit");
		
		if(inherits != null)
			for(int i = 0; i < inherits.$length(); i++){
				if(inherits.$get(i) == _interface){
					return (T) this;
				}
			}
		
		return null;
	}
}
