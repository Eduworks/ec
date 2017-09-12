package org.schema;

/**
 * Schema.org/PaymentService
 * A Service to transfer funds from a person or organization to a beneficiary person or organization.
 * @author schema.org
 * @class PaymentService
 * @module org.schema
 * @extends FinancialProduct
 */
public class PaymentService extends FinancialProduct
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PaymentService()
	{
		context="http://schema.org/";
		type="PaymentService";
	}

}