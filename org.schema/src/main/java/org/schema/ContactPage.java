package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ContactPage
 * Web page type: Contact page.
 * @author schema.org
 * @class ContactPage
 * @module org.schema
 * @extends WebPage
 */
public class ContactPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ContactPage()
	{
		context="http://schema.org/";
		type="ContactPage";
	}

}