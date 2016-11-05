package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GroceryStore
 * A grocery store.
 * @author schema.org
 * @module schema.org
 * @class GroceryStore
 * @extends Store
 */
public class GroceryStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GroceryStore()
	{
		context="http://schema.org/";
		type="GroceryStore";
	}

}