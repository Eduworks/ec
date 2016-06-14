package com.eduworks.ec.framework;

import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;

import com.eduworks.ec.framework.view.EcView;

/**
 * Parent class of all view manager classes, stores a cache of the views and their corresponding DOM selectors
 * and provides functions for setting a view to correspond to a selector and displaying a view after it has 
 * been added to the cache. 
 * 
 * @author devlin.junker@eduworks.com
 *
 */
public class ViewManager {
	
	/**
	 * Storage that maps view class instances to DOM Elements
	 */
	private static Map<String, EcView> viewMap = JSCollections.$map();
	
	/**
	 * Set's the view instance for a specific DOM selector
	 * 
	 * @param containerId
	 * 			DOM Selector for the element that will correspond to the view
	 * @param view
	 * 			View that will correspond to the DOM Selector
	 */
	protected static void setView(String containerId, EcView view)
	{
		viewMap.$put(containerId, view);
	}
	
	/**
	 * Returns the view instance that currently corresponds to a specific DOM selector
	 * 
	 * @param containerId
	 * 			DOM Selector that corresponds to the view to be returned
	 * @return
	 * 			The view that corresponds to the DOM Selector passed in, or null if no view corresponds with it
	 */
	protected static EcView getView(String containerId)
	{
		return viewMap.$get(containerId);
	}
	
	/**
	 * Relates the view to a DOM Selector and calls the view's display function to populate the inner html
	 * of the DOM Selector Element
	 * 
	 * @param view
	 * 			View to be displayed in the DOM Selector Element
	 * @param containerId
	 * 			DOM Selector for element that the view will be displayed in
	 * @param callback
	 * 			Callback function to be passed in to the view's display function (to be called once the view has been displayed)
	 */
	public static void showView(EcView view, String containerId, Callback0 callback)
	{
		setView(containerId, view);
		
		view.display(containerId, callback);
	}
}
