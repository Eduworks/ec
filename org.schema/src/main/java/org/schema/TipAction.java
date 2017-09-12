package org.schema;

/**
 * Schema.org/TipAction
 * The act of giving money voluntarily to a beneficiary in recognition of services rendered.
 *
 * @author schema.org
 * @class TipAction
 * @module org.schema
 * @extends TradeAction
 */
public class TipAction extends TradeAction {
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
	public TipAction() {
		context = "http://schema.org/";
		type = "TipAction";
	}

}