package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ItemPage
 * A page devoted to a single item, such as a particular product or hotel.
 * @author schema.org
 * @class ItemPage
 * @module org.schema
 * @extends WebPage
 */
public class ItemPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ItemPage()
	{
		context="http://schema.org/";
		type="ItemPage";
	}

}