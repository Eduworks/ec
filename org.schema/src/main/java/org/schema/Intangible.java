package org.schema;

/**
 * Schema.org/Intangible
 * A utility class that serves as the umbrella for a number of 'intangible' things such as quantities, structured values, etc.
 * @author schema.org
 * @class Intangible
 * @module org.schema
 * @extends Thing
 */
public class Intangible extends Thing
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Intangible()
	{
		context="http://schema.org/";
		type="Intangible";
	}

}