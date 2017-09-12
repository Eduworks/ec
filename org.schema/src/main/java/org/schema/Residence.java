package org.schema;

/**
 * Schema.org/Residence
 * The place where a person lives.
 * @author schema.org
 * @class Residence
 * @module org.schema
 * @extends Place
 */
public class Residence extends Place
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Residence()
	{
		context="http://schema.org/";
		type="Residence";
	}

}