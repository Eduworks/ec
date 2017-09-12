package org.schema;

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