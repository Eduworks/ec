package org.schema;

/**
 * Schema.org/WebSite
 * A WebSite is a set of related web pages and other items typically served from a single web domain and accessible via URLs.
 *
 * @author schema.org
 * @class WebSite
 * @module org.schema
 * @extends CreativeWork
 */
public class WebSite extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WebSite() {
		context = "http://schema.org/";
		type = "WebSite";
	}

}