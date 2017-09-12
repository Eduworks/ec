package org.schema;

/**
 * Schema.org/RestrictedDiet
 * A diet restricted to certain foods or preparations for cultural, religious, health or lifestyle reasons.
 *
 * @author schema.org
 * @class RestrictedDiet
 * @module org.schema
 * @extends Enumeration
 */
public class RestrictedDiet extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RestrictedDiet() {
		context = "http://schema.org/";
		type = "RestrictedDiet";
	}

}