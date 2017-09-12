package org.schema;

/**
 * Schema.org/SellAction
 * The act of taking money from a buyer in exchange for goods or services rendered. An agent sells an object, product, or service to a buyer for a price. Reciprocal of BuyAction.
 * @author schema.org
 * @class SellAction
 * @module org.schema
 * @extends TradeAction
 */
public class SellAction extends TradeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SellAction()
	{
		context="http://schema.org/";
		type="SellAction";
	}

	/**
	 * Schema.org/warrantyPromise
	 * The warranty promise(s) included in the offer.
	 * @property warrantyPromise
	 * @type WarrantyPromise
	 */
	public WarrantyPromise warrantyPromise;

	/**
	 * Schema.org/buyer
	 * A sub property of participant. The participant/person/organization that bought the object.
	 * @property buyer
	 * @type Person
	 */
	public Person buyer;

}