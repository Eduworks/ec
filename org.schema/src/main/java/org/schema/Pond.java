package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Pond
 * A pond.
 * @author schema.org
 * @module schema.org
 * @class Pond
 * @extends BodyOfWater
 */
public class Pond extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Pond()
	{
		context="http://schema.org/";
		type="Pond";
	}

}