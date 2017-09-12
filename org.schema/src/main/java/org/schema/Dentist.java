package org.schema;

/**
 * Schema.org/Dentist
 * A dentist.
 * @author schema.org
 * @class Dentist
 * @module org.schema
 * @extends LocalBusiness
 */
public class Dentist extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Dentist()
	{
		context="http://schema.org/";
		type="Dentist";
	}

}