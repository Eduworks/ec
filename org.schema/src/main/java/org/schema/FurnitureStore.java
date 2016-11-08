package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/FurnitureStore
 * A furniture store.
 * @author schema.org
 * @class FurnitureStore
 * @module org.schema
 * @extends Store
 */
public class FurnitureStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FurnitureStore()
	{
		context="http://schema.org/";
		type="FurnitureStore";
	}

}