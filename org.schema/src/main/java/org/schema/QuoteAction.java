package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/QuoteAction
 * An agent quotes/estimates/appraises an object/product/service with a price at a location/store.
 * @author schema.org
 * @module schema.org
 * @class QuoteAction
 * @extends TradeAction
 */
public class QuoteAction extends TradeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public QuoteAction()
	{
		context="http://schema.org/";
		type="QuoteAction";
	}

}