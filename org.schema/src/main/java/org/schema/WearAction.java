package org.schema;

/**
 * Schema.org/WearAction
 * The act of dressing oneself in clothing.
 *
 * @author schema.org
 * @class WearAction
 * @module org.schema
 * @extends UseAction
 */
public class WearAction extends UseAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WearAction() {
		context = "http://schema.org/";
		type = "WearAction";
	}

}