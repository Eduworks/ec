package org.schema;

/**
 * Schema.org/WebPageElement
 * A web page element, like a table or an image.
 *
 * @author schema.org
 * @class WebPageElement
 * @module org.schema
 * @extends CreativeWork
 */
public class WebPageElement extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WebPageElement() {
		context = "http://schema.org/";
		type = "WebPageElement";
	}

}