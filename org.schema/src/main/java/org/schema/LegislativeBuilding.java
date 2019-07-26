package org.schema;

/**
 * Schema.org/LegislativeBuilding
 * A legislative building&#x2014;for example, the state capitol.
 *
 * @author schema.org
 * @class LegislativeBuilding
 * @module org.schema
 * @extends GovernmentBuilding
 */
public class LegislativeBuilding extends GovernmentBuilding {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LegislativeBuilding() {
		context = "http://schema.org/";
		type = "LegislativeBuilding";
	}

}