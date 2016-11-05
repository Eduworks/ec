package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WPHeader
 * The header section of the page.
 * @author schema.org
 * @module schema.org
 * @class WPHeader
 * @extends WebPageElement
 */
public class WPHeader extends WebPageElement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WPHeader()
	{
		context="http://schema.org/";
		type="WPHeader";
	}

}