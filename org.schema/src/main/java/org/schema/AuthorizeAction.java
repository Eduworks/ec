package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AuthorizeAction
 * The act of granting permission to an object.
 * @author schema.org
 * @module schema.org
 * @class AuthorizeAction
 * @extends AllocateAction
 */
public class AuthorizeAction extends AllocateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AuthorizeAction()
	{
		context="http://schema.org/";
		type="AuthorizeAction";
	}

	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 * @property recipient
	 * @type schema,Organization | schema,Person | schema,Audience	 */
	public Object recipient;

}