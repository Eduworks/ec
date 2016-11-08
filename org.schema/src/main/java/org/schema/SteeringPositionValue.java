package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SteeringPositionValue
 * A value indicating a steering position.
 * @author schema.org
 * @class SteeringPositionValue
 * @module org.schema
 * @extends QualitativeValue
 */
public class SteeringPositionValue extends QualitativeValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SteeringPositionValue()
	{
		context="http://schema.org/";
		type="SteeringPositionValue";
	}

}