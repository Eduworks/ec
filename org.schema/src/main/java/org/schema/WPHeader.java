package org.schema;

/**
 * Schema.org/WPHeader
 * The header section of the page.
 *
 * @author schema.org
 * @class WPHeader
 * @module org.schema
 * @extends WebPageElement
 */
public class WPHeader extends WebPageElement {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WPHeader() {
		context = "http://schema.org/";
		type = "WPHeader";
	}

}