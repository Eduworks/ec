package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PaymentService
 * A Service to transfer funds from a person or organization to a beneficiary person or organization.
 * @author schema.org
 * @module schema.org
 * @class PaymentService
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