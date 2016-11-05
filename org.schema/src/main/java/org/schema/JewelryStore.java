package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/JewelryStore
 * A jewelry store.
 * @author schema.org
 * @module schema.org
 * @class JewelryStore
 * @extends Store
 */
public class JewelryStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public JewelryStore()
	{
		context="http://schema.org/";
		type="JewelryStore";
	}

}