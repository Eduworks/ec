package org.schema;

/**
 * Schema.org/PaymentCard
 * A payment method using a credit, debit, store or other card to associate the payment with an account.
 *
 * @author schema.org
 * @class PaymentCard
 * @module org.schema
 * @extends FinancialProduct
 */
public class PaymentCard extends FinancialProduct {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PaymentCard() {
		context = "http://schema.org/";
		type = "PaymentCard";
	}

}