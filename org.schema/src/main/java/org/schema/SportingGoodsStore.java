package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SportingGoodsStore
 * A sporting goods store.
 * @author schema.org
 * @module schema.org
 * @class SportingGoodsStore
 * @extends Store
 */
public class SportingGoodsStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportingGoodsStore()
	{
		context="http://schema.org/";
		type="SportingGoodsStore";
	}

}