package org.schema;

/**
 * Schema.org/PawnShop
 * A shop that will buy, or lend money against the security of, personal possessions.
 *
 * @author schema.org
 * @class PawnShop
 * @module org.schema
 * @extends Store
 */
public class PawnShop extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PawnShop() {
		context = "http://schema.org/";
		type = "PawnShop";
	}

}