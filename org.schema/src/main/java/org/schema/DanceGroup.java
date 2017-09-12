package org.schema;

/**
 * Schema.org/DanceGroup
 * A dance group&#x2014;for example, the Alvin Ailey Dance Theater or Riverdance.
 * @author schema.org
 * @class DanceGroup
 * @module org.schema
 * @extends PerformingGroup
 */
public class DanceGroup extends PerformingGroup
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DanceGroup()
	{
		context="http://schema.org/";
		type="DanceGroup";
	}

}