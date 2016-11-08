package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Reservoir
 * A reservoir of water, typically an artificially created lake, like the Lake Kariba reservoir.
 * @author schema.org
 * @class Reservoir
 * @module org.schema
 * @extends BodyOfWater
 */
public class Reservoir extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Reservoir()
	{
		context="http://schema.org/";
		type="Reservoir";
	}

}