package org.schema;

/**
 * Schema.org/CancelAction
 * The act of asserting that a future event/action is no longer going to happen.\n\nRelated actions:\n\n* [[ConfirmAction]]: The antonym of CancelAction.
 *
 * @author schema.org
 * @class CancelAction
 * @module org.schema
 * @extends PlanAction
 */
public class CancelAction extends PlanAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CancelAction() {
		context = "http://schema.org/";
		type = "CancelAction";
	}

}