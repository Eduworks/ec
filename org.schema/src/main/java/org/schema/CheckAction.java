package org.schema;

/**
 * Schema.org/CheckAction
 * An agent inspects, determines, investigates, inquires, or examines an object's accuracy, quality, condition, or state.
 *
 * @author schema.org
 * @class CheckAction
 * @module org.schema
 * @extends FindAction
 */
public class CheckAction extends FindAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CheckAction() {
		context = "http://schema.org/";
		type = "CheckAction";
	}

}