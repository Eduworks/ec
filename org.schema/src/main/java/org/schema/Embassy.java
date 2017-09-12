package org.schema;

/**
 * Schema.org/Embassy
 * An embassy.
 * @author schema.org
 * @class Embassy
 * @module org.schema
 * @extends GovernmentBuilding
 */
public class Embassy extends GovernmentBuilding
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Embassy()
	{
		context="http://schema.org/";
		type="Embassy";
	}

}