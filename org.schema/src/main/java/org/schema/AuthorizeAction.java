package org.schema;

/**
 * Schema.org/AuthorizeAction
 * The act of granting permission to an object.
 *
 * @author schema.org
 * @class AuthorizeAction
 * @module org.schema
 * @extends AllocateAction
 */
public class AuthorizeAction extends AllocateAction {
	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 *
	 * @property recipient
	 * @type Organization
	 */
	public Organization recipient;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AuthorizeAction() {
		context = "http://schema.org/";
		type = "AuthorizeAction";
	}

}