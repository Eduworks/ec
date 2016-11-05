package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WebPageElement
 * A web page element, like a table or an image.
 * @author schema.org
 * @module schema.org
 * @class WebPageElement
 * @extends CreativeWork
 */
public class WebPageElement extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WebPageElement()
	{
		context="http://schema.org/";
		type="WebPageElement";
	}

}