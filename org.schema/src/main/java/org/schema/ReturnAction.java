package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReturnAction
 * The act of returning to the origin that which was previously received (concrete objects) or taken (ownership).
 * @author schema.org
 * @module schema.org
 * @class ReturnAction
 * @extends TransferAction
 */
public class ReturnAction extends TransferAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReturnAction()
	{
		context="http://schema.org/";
		type="ReturnAction";
	}

	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 * @property recipient
	 * @type schema,Organization | schema,Person | schema,Audience	 */
	public Object recipient;

}