package org.schema;

/**
 * Schema.org/RejectAction
 * The act of rejecting to/adopting an object.\n\nRelated actions:\n\n* [[AcceptAction]]: The antonym of RejectAction.
 *
 * @author schema.org
 * @class RejectAction
 * @module org.schema
 * @extends AllocateAction
 */
public class RejectAction extends AllocateAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RejectAction() {
		context = "http://schema.org/";
		type = "RejectAction";
	}

}