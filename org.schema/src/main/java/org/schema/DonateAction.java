package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DonateAction
 * The act of providing goods, services, or money without compensation, often for philanthropic reasons.
 * @author schema.org
 * @module schema.org
 * @class DonateAction
 * @extends TradeAction
 */
public class DonateAction extends TradeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DonateAction()
	{
		context="http://schema.org/";
		type="DonateAction";
	}

	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 * @property recipient
	 * @type schema,Organization | schema,Person | schema,Audience	 */
	public Object recipient;

}