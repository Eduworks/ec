package org.schema;

/**
 * Schema.org/QuoteAction
 * An agent quotes/estimates/appraises an object/product/service with a price at a location/store.
 *
 * @author schema.org
 * @class QuoteAction
 * @module org.schema
 * @extends TradeAction
 */
public class QuoteAction extends TradeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public QuoteAction() {
		context = "http://schema.org/";
		type = "QuoteAction";
	}

}