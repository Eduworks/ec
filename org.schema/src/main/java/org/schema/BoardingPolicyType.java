package org.schema;

/**
 * Schema.org/BoardingPolicyType
 * A type of boarding policy used by an airline.
 *
 * @author schema.org
 * @class BoardingPolicyType
 * @module org.schema
 * @extends Enumeration
 */
public class BoardingPolicyType extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BoardingPolicyType() {
		context = "http://schema.org/";
		type = "BoardingPolicyType";
	}

}