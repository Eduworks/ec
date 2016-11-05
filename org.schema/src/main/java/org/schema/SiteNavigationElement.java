package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SiteNavigationElement
 * A navigation element of the page.
 * @author schema.org
 * @module schema.org
 * @class SiteNavigationElement
 * @extends WebPageElement
 */
public class SiteNavigationElement extends WebPageElement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SiteNavigationElement()
	{
		context="http://schema.org/";
		type="SiteNavigationElement";
	}

}