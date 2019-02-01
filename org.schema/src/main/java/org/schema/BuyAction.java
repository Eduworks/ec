package org.schema;

/**
 * Schema.org/BuyAction
 * The act of giving money to a seller in exchange for goods or services rendered. An agent buys an object, product, or service from a seller for a price. Reciprocal of SellAction.
 *
 * @author schema.org
 * @class BuyAction
 * @module org.schema
 * @extends TradeAction
 */
public class BuyAction extends TradeAction {
	/**
	 * Schema.org/vendor
	 * 'vendor' is an earlier term for 'seller'.
	 *
	 * @property vendor
	 * @type Organization
	 */
	public Organization vendor;
	/**
	 * Schema.org/seller
	 * An entity which offers (sells / leases / lends / loans) the services / goods.  A seller may also be a provider.
	 *
	 * @property seller
	 * @type Person
	 */
	public Person seller;
	/**
	 * Schema.org/warrantyPromise
	 * The warranty promise(s) included in the offer.
	 *
	 * @property warrantyPromise
	 * @type WarrantyPromise
	 */
	public WarrantyPromise warrantyPromise;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BuyAction() {
		context = "http://schema.org/";
		type = "BuyAction";
	}

}