package org.schema;

/**
 * Schema.org/DefenceEstablishment
 * A defence establishment, such as an army or navy base.
 *
 * @author schema.org
 * @class DefenceEstablishment
 * @module org.schema
 * @extends GovernmentBuilding
 */
public class DefenceEstablishment extends GovernmentBuilding {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DefenceEstablishment() {
		context = "http://schema.org/";
		type = "DefenceEstablishment";
	}

}