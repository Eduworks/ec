package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OutletStore
 * An outlet store.
 * @author schema.org
 * @module schema.org
 * @class OutletStore
 * @extends Store
 */
public class OutletStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OutletStore()
	{
		context="http://schema.org/";
		type="OutletStore";
	}

}