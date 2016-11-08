package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WholesaleStore
 * A wholesale store.
 * @author schema.org
 * @class WholesaleStore
 * @module org.schema
 * @extends Store
 */
public class WholesaleStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WholesaleStore()
	{
		context="http://schema.org/";
		type="WholesaleStore";
	}

}