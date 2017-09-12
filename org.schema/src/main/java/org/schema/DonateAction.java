package org.schema;

/**
 * Schema.org/DonateAction
 * The act of providing goods, services, or money without compensation, often for philanthropic reasons.
 *
 * @author schema.org
 * @class DonateAction
 * @module org.schema
 * @extends TradeAction
 */
public class DonateAction extends TradeAction {
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
	public DonateAction() {
		context = "http://schema.org/";
		type = "DonateAction";
	}

}