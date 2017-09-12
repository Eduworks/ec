package org.schema;

/**
 * Schema.org/DrinkAction
 * The act of swallowing liquids.
 *
 * @author schema.org
 * @class DrinkAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class DrinkAction extends ConsumeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DrinkAction() {
		context = "http://schema.org/";
		type = "DrinkAction";
	}

}