package com.eduworks.ec.framework.view.manager;

import com.eduworks.ec.framework.view.EcView;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback3;
import org.stjs.javascript.jquery.GlobalJQuery;
import org.stjs.javascript.jquery.JQueryXHR;

/**
 * Parent class of all view manager classes, stores a cache of the views and
 * their corresponding DOM selectors and provides functions for setting a view
 * to correspond to a selector and displaying a view after it has been added to
 * the cache.
 * 
 * @module com.eduworks.ec.ui
 * @class ViewManager
 * 
 * @author devlin.junker@eduworks.com
 */
public class ViewManager
{

	/**
	 * Storage that maps view class instances to DOM Elements
	 * 
	 * @private
	 * @property viewMap
	 * @type Map<String, EcView>
	 */
	protected static Map<String, EcView> viewMap = JSCollections.$map();

	/**
	 * Set's the view instance for a specific DOM selector
	 * 
	 * @memberOf ViewManager
	 * @method setView
	 * @param {String} containerId
	 *            DOM Selector for the element that will correspond to the view
	 * @param {EcView} view
	 *            View that will correspond to the DOM Selector
	 */
	protected static void setView(String containerId, EcView view)
	{
		viewMap.$put(containerId, view);
	}

	/**
	 * Returns the view instance that currently corresponds to a specific DOM
	 * selector
	 * 
	 * @memberOf ViewManager
	 * @method getView
	 * @param {String} containerId
	 *          DOM Selector that corresponds to the view to be returned
	 * @return {EcView} 
	 * 			The view that corresponds to the DOM Selector passed in, or null
	 *         	if no view corresponds with it
	 */
	public static EcView getView(String containerId)
	{
		return viewMap.$get(containerId);
	}

	/**
	 * Relates the view to a DOM Selector and calls the view's display function
	 * to populate the inner html of the DOM Selector Element
	 * 
	 * @memberOf ViewManager
	 * @method showView
	 * @param {EcView} view
	 *            View to be displayed in the DOM Selector Element
	 * @param {String} containerId
	 *            DOM Selector for element that the view will be displayed in
	 * @param {Callback0} callback
	 *            Callback function to be passed in to the view's display
	 *            function (to be called once the view has been displayed)
	 */
	public static void showView(final EcView view, final String containerId, final Callback0 callback)
	{
		String htmlLocation = view.getHtmlLocation();

		if (htmlLocation != null)
		{
			EcView oldView = getView(containerId);
			setView(containerId, view);
			if (oldView != null)
				oldView.onClose();

			GlobalJQuery.$(containerId).load(htmlLocation, null, new Callback3<Object, String, JQueryXHR>()
			{
				@Override
				public void $invoke(Object p1, String p2, JQueryXHR p3)
				{
					view.display(containerId);

					if (callback != null)
						callback.$invoke();
				}
			});
		}

		GlobalJQuery.$(containerId).removeClass("hide");
	}

	/**
	 * Hides the container specified by the containerId by adding 'hide' class
	 * 
	 * @memberOf ViewManager
	 * @method hideView
	 * @param {String} containerId
	 *            DOM Selector for the element to add the 'hide' class to
	 */
	public static void hideView(String containerId)
	{
		GlobalJQuery.$(containerId).addClass("hide");
	}

	public static void destroyView(String containerId){
		if (getView(containerId) == null)
			return;
		getView(containerId).onClose();
		viewMap.$delete(containerId);
	}
}
