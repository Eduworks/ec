package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Canal
 * A canal, like the Panama Canal.
 * @author schema.org
 * @module schema.org
 * @class Canal
 * @extends BodyOfWater
 */
public class Canal extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Canal()
	{
		context="http://schema.org/";
		type="Canal";
	}

}