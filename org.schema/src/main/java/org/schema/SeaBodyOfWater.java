package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SeaBodyOfWater
 * A sea (for example, the Caspian sea).
 * @author schema.org
 * @class SeaBodyOfWater
 * @module org.schema
 * @extends BodyOfWater
 */
public class SeaBodyOfWater extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SeaBodyOfWater()
	{
		context="http://schema.org/";
		type="SeaBodyOfWater";
	}

}