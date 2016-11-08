package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ItemListOrderType
 * Enumerated for values for itemListOrder for indicating how an ordered ItemList is organized.
 * @author schema.org
 * @class ItemListOrderType
 * @module org.schema
 * @extends Enumeration
 */
public class ItemListOrderType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ItemListOrderType()
	{
		context="http://schema.org/";
		type="ItemListOrderType";
	}

}