package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HomeGoodsStore
 * A home goods store.
 * @author schema.org
 * @module schema.org
 * @class HomeGoodsStore
 * @extends Store
 */
public class HomeGoodsStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HomeGoodsStore()
	{
		context="http://schema.org/";
		type="HomeGoodsStore";
	}

}