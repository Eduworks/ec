package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WPFooter
 * The footer section of the page.
 * @author schema.org
 * @module schema.org
 * @class WPFooter
 * @extends WebPageElement
 */
public class WPFooter extends WebPageElement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WPFooter()
	{
		context="http://schema.org/";
		type="WPFooter";
	}

}