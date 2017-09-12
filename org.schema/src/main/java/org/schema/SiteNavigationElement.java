package org.schema;

/**
 * Schema.org/SiteNavigationElement
 * A navigation element of the page.
 * @author schema.org
 * @class SiteNavigationElement
 * @module org.schema
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