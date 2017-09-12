package org.schema;

/**
 * Schema.org/ReturnAction
 * The act of returning to the origin that which was previously received (concrete objects) or taken (ownership).
 *
 * @author schema.org
 * @class ReturnAction
 * @module org.schema
 * @extends TransferAction
 */
public class ReturnAction extends TransferAction {
	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 *
	 * @property recipient
	 * @type schema, Organization | schema,Person | schema,Audience
	 */
	public Object recipient;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ReturnAction() {
		context = "http://schema.org/";
		type = "ReturnAction";
	}

}