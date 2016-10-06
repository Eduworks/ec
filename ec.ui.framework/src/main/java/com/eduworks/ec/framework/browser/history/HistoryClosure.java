package com.eduworks.ec.framework.browser.history;

import com.eduworks.ec.framework.view.EcScreen;

/**
 * Object stored in the ScreenManager's history cache array, to keep track of the history of screens and 
 * which DOM element they were displayed in
 * 
 * @author devlin.junker@eduworks.com
 *
 */
public class HistoryClosure {
	/**
	 * Name of the page (used to retrieve the correct screen on a back/forward button press)
	 */
	public String pageName;
	/**
	 * Screen to store and associate with the page name so that it can be loaded if necessary
	 */
	public EcScreen screen;
	/**
	 * ID of the container to display the screen in, once it has been found by page name
	 */
	public String containerId;
	
	/**
	 * Constructor for the HistoryClosure Object
	 * 
	 * @param name
	 * 			Page Name associated with this page (used for loading history screens)
	 * @param screen
	 * 			Screen to associate with the page name (to display when loading history screens)
	 * @param containerId
	 * 			DOM Selector (ID) of the HTML container to display the screen in on load history
	 */
	public HistoryClosure(String name, EcScreen screen, String containerId){
		this.pageName = name;
		this.screen = screen;
		this.containerId = containerId;
	}
}
