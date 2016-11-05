package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BikeStore
 * A bike store.
 * @author schema.org
 * @module schema.org
 * @class BikeStore
 * @extends Store
 */
public class BikeStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BikeStore()
	{
		context="http://schema.org/";
		type="BikeStore";
	}

}