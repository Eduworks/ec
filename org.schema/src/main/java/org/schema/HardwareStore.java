package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HardwareStore
 * A hardware store.
 * @author schema.org
 * @module schema.org
 * @class HardwareStore
 * @extends Store
 */
public class HardwareStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HardwareStore()
	{
		context="http://schema.org/";
		type="HardwareStore";
	}

}