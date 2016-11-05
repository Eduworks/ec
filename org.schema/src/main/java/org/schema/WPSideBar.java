package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WPSideBar
 * A sidebar section of the page.
 * @author schema.org
 * @module schema.org
 * @class WPSideBar
 * @extends WebPageElement
 */
public class WPSideBar extends WebPageElement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WPSideBar()
	{
		context="http://schema.org/";
		type="WPSideBar";
	}

}