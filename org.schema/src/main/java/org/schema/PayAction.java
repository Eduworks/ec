package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PayAction
 * An agent pays a price to a participant.
 * @author schema.org
 * @module schema.org
 * @class PayAction
 * @extends TradeAction
 */
public class PayAction extends TradeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PayAction()
	{
		context="http://schema.org/";
		type="PayAction";
	}

	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 * @property recipient
	 * @type schema,Organization | schema,Person | schema,Audience	 */
	public Object recipient;

}