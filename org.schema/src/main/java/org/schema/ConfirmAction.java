package org.schema;

/**
 * Schema.org/ConfirmAction
 * The act of notifying someone that a future event/action is going to happen as expected.\n\nRelated actions:\n\n* [[CancelAction]]: The antonym of ConfirmAction.
 *
 * @author schema.org
 * @class ConfirmAction
 * @module org.schema
 * @extends InformAction
 */
public class ConfirmAction extends InformAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ConfirmAction() {
		context = "http://schema.org/";
		type = "ConfirmAction";
	}

}