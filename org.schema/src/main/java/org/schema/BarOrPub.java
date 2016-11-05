package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BarOrPub
 * A bar or pub.
 * @author schema.org
 * @module schema.org
 * @class BarOrPub
 * @extends FoodEstablishment
 */
public class BarOrPub extends FoodEstablishment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BarOrPub()
	{
		context="http://schema.org/";
		type="BarOrPub";
	}

}