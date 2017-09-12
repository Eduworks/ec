package org.schema;

/**
 * Schema.org/WPAdBlock
 * An advertising section of the page.
 * @author schema.org
 * @class WPAdBlock
 * @module org.schema
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