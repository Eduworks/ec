package org.schema;

/**
 * Schema.org/BusStation
 * A bus station.
 * @author schema.org
 * @class BusStation
 * @module org.schema
 * @extends CivicStructure
 */
public class BusStation extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BusStation()
	{
		context="http://schema.org/";
		type="BusStation";
	}

}