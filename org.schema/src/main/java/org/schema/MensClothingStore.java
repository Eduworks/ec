package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MensClothingStore
 * A men's clothing store.
 * @author schema.org
 * @class MensClothingStore
 * @module org.schema
 * @extends Store
 */
public class MensClothingStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MensClothingStore()
	{
		context="http://schema.org/";
		type="MensClothingStore";
	}

}