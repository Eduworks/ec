package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GardenStore
 * A garden store.
 * @author schema.org
 * @class GardenStore
 * @module org.schema
 * @extends Store
 */
public class GardenStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GardenStore()
	{
		context="http://schema.org/";
		type="GardenStore";
	}

}