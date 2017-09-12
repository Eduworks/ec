package org.schema;

/**
 * Schema.org/AdministrativeArea
 * A geographical region, typically under the jurisdiction of a particular government.
 * @author schema.org
 * @class AdministrativeArea
 * @module org.schema
 * @extends Place
 */
public class AdministrativeArea extends Place
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AdministrativeArea()
	{
		context="http://schema.org/";
		type="AdministrativeArea";
	}

}