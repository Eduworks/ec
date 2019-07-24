package org.schema;

/**
 * Schema.org/AutoWash
 * A car wash business.
 *
 * @author schema.org
 * @class AutoWash
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class AutoWash extends AutomotiveBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AutoWash() {
		context = "http://schema.org/";
		type = "AutoWash";
	}

}