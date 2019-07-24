package com.eduworks.ec.framework.browser.history;

import com.eduworks.ec.framework.view.EcScreen;

/**
 * Object stored in the ScreenManager's history cache array, to keep track of the history of screens and
 * which DOM element they were displayed in
 *
 * @author devlin.junker@eduworks.com
 * @module com.eduworks.ec.ui
 * @class HistoryClosure
 */
public class HistoryClosure {
	/**
	 * Name of the page (used to retrieve the correct screen on a back/forward button press)
	 *
	 * @property pageName
	 * @type String
	 */
	public String pageName;
	/**
	 * Screen to store and associate with the page name so that it can be loaded if necessary
	 *
	 * @property screen
	 * @type EcScreen
	 */
	public EcScreen screen;
	/**
	 * ID of the container to display the screen in, once it has been found by page name
	 *
	 * @property containerId
	 * @type String
	 */
	public String containerId;
	/**
	 * URL Parameters associated with the screen
	 *
	 * @property screenParameters
	 * @type Object
	 */
	public Object screenParameters;

	/**
	 * Constructor for the HistoryClosure Object
	 *
	 * @param {String}   name
	 *                   Page Name associated with this page (used for loading history screens)
	 * @param {EcScreen} screen
	 *                   Screen to associate with the page name (to display when loading history screens)
	 * @param {String}   containerId
	 *                   DOM Selector (ID) of the HTML container to display the screen in on load history
	 * @param {Object}   params
	 *                   URL Params associated with the screen shown
	 * @constructor
	 */
	public HistoryClosure(String name, EcScreen screen, String containerId, Object params) {
		this.pageName = name;
		this.screen = screen;
		this.containerId = containerId;
		this.screenParameters = params;
	}
}
