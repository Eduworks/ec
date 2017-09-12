package org.schema;

/**
 * Schema.org/ChildCare
 * A Childcare center.
 *
 * @author schema.org
 * @class ChildCare
 * @module org.schema
 * @extends LocalBusiness
 */
public class ChildCare extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ChildCare() {
		context = "http://schema.org/";
		type = "ChildCare";
	}

}