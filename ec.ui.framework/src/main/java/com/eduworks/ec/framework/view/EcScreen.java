package com.eduworks.ec.framework.view;

import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.JSStringAdapter;
import org.stjs.javascript.Map;

/**
 * Subclass of view that is specific for a screen, providing a display name that
 * will be shown in the URL bar and that can be used on startup to check if the
 * URL is asking for a certain page on startup.
 * 
 * @module com.eduworks.ec.ui
 * @class EcScreen
 * @extends EcView
 * 
 * @author devlin.junker@eduworks.com
 */
public abstract class EcScreen extends EcView {
	/**
	 * Name that identifies a certain type of screen, shown in the URL bar to
	 * help the user understand the page that they are on and used during
	 * startup to decide whether or not to load a specifici page on startup.
	 * 
	 * @property displayName
	 * @type string
	 */
	public String displayName = "";

	/**
	 * Getter for the display name
	 * 
	 * @memberOf EcScreen
	 * @method getDisplayName
	 * @return The display name for the screen
	 */
	public String getDisplayName() {
		return displayName;
	};

	
	public void setData(Object data)
	{
		
	}
}
