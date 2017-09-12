package org.schema;

/**
 * Schema.org/ContactPage
 * Web page type: Contact page.
 *
 * @author schema.org
 * @class ContactPage
 * @module org.schema
 * @extends WebPage
 */
public class ContactPage extends WebPage {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ContactPage() {
		context = "http://schema.org/";
		type = "ContactPage";
	}

}