package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AboutPage
 * Web page type: About page.
 * @author schema.org
 * @class AboutPage
 * @module org.schema
 * @extends WebPage
 */
public class AboutPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AboutPage()
	{
		context="http://schema.org/";
		type="AboutPage";
	}

}