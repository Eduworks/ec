package org.schema;

/**
 * Schema.org/Enumeration
 * Lists or enumerations—for example, a list of cuisines or music genres, etc.
 * @author schema.org
 * @class Enumeration
 * @module org.schema
 * @extends Intangible
 */
public class Enumeration extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Enumeration()
	{
		context="http://schema.org/";
		type="Enumeration";
	}

}