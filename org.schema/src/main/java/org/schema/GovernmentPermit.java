package org.schema;

/**
 * Schema.org/GovernmentPermit
 * A permit issued by a government agency.
 *
 * @author schema.org
 * @class GovernmentPermit
 * @module org.schema
 * @extends Permit
 */
public class GovernmentPermit extends Permit {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GovernmentPermit() {
		context = "http://schema.org/";
		type = "GovernmentPermit";
	}

}