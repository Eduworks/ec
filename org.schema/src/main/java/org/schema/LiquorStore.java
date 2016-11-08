package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LiquorStore
 * A shop that sells alcoholic drinks such as wine, beer, whisky and other spirits.
 * @author schema.org
 * @class LiquorStore
 * @module org.schema
 * @extends Store
 */
public class LiquorStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LiquorStore()
	{
		context="http://schema.org/";
		type="LiquorStore";
	}

}