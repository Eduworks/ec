package com.eduworks.ec.framework;

import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;

import com.eduworks.ec.framework.view.EcView;

public class ViewManager {
	
	private static Map<String, EcView> viewMap = JSCollections.$map();
	
	protected static void setView(String containerId, EcView view)
	{
		viewMap.$put(containerId, view);
	}
	
	protected static EcView getView(String containerId)
	{
		return viewMap.$get(containerId);
	}
	
	public static void showView(EcView view, String containerId, Callback0 callback)
	{
		setView(containerId, view);
		
		view.display(containerId, callback);
	}
}
