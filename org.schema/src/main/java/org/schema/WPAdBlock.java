package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WPAdBlock
 * An advertising section of the page.
 * @author schema.org
 * @module schema.org
 * @class WPAdBlock
 * @extends WebPageElement
 */
public class WPAdBlock extends WebPageElement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WPAdBlock()
	{
		context="http://schema.org/";
		type="WPAdBlock";
	}

}