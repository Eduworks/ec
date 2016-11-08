package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LakeBodyOfWater
 * A lake (for example, Lake Pontrachain).
 * @author schema.org
 * @class LakeBodyOfWater
 * @module org.schema
 * @extends BodyOfWater
 */
public class LakeBodyOfWater extends BodyOfWater
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LakeBodyOfWater()
	{
		context="http://schema.org/";
		type="LakeBodyOfWater";
	}

}