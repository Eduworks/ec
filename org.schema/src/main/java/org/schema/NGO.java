package org.schema;

/**
 * Schema.org/NGO
 * Organization: Non-governmental Organization.
 * @author schema.org
 * @class NGO
 * @module org.schema
 * @extends Organization
 */
public class NGO extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public NGO()
	{
		context="http://schema.org/";
		type="NGO";
	}

}