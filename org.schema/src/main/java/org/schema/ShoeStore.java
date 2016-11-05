package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ShoeStore
 * A shoe store.
 * @author schema.org
 * @module schema.org
 * @class ShoeStore
 * @extends Store
 */
public class ShoeStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ShoeStore()
	{
		context="http://schema.org/";
		type="ShoeStore";
	}

}