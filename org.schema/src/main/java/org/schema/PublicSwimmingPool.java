package org.schema;

/**
 * Schema.org/PublicSwimmingPool
 * A public swimming pool.
 * @author schema.org
 * @class PublicSwimmingPool
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class PublicSwimmingPool extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PublicSwimmingPool()
	{
		context="http://schema.org/";
		type="PublicSwimmingPool";
	}

}