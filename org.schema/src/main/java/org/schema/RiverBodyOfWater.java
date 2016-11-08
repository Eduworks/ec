package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RiverBodyOfWater
 * A river (for example, the broad majestic Shannon).
 * @author schema.org
 * @class RiverBodyOfWater
 * @module org.schema
 * @extends BodyOfWater
 */
public class RiverBodyOfWater extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RiverBodyOfWater()
	{
		context="http://schema.org/";
		type="RiverBodyOfWater";
	}

}