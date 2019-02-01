package org.schema;

/**
 * Schema.org/PayAction
 * An agent pays a price to a participant.
 *
 * @author schema.org
 * @class PayAction
 * @module org.schema
 * @extends TradeAction
 */
public class PayAction extends TradeAction {
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
	public PayAction() {
		context = "http://schema.org/";
		type = "PayAction";
	}

}