package org.schema;

/**
 * Schema.org/PoliceStation
 * A police station.
 * @author schema.org
 * @class PoliceStation
 * @module org.schema
 * @extends CivicStructure
 */
public class PoliceStation extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PoliceStation()
	{
		context="http://schema.org/";
		type="PoliceStation";
	}

}