package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CheckoutPage
 * Web page type: Checkout page.
 * @author schema.org
 * @class CheckoutPage
 * @module org.schema
 * @extends WebPage
 */
public class CheckoutPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CheckoutPage()
	{
		context="http://schema.org/";
		type="CheckoutPage";
	}

}