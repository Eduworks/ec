package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BodyOfWater
 * A body of water, such as a sea, ocean, or lake.
 * @author schema.org
 * @class BodyOfWater
 * @module org.schema
 * @extends Landform
 */
public class BodyOfWater extends Landform
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BodyOfWater()
	{
		context="http://schema.org/";
		type="BodyOfWater";
	}

}