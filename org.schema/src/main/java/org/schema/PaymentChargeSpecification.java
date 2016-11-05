package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PaymentChargeSpecification
 * The costs of settling the payment using a particular payment method.
 * @author schema.org
 * @module schema.org
 * @class PaymentChargeSpecification
 * @extends PriceSpecification
 */
public class PaymentChargeSpecification extends PriceSpecification
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PaymentChargeSpecification()
	{
		context="http://schema.org/";
		type="PaymentChargeSpecification";
	}

	/**
	 * Schema.org/appliesToDeliveryMethod
	 * The delivery method(s) to which the delivery charge or payment charge specification applies.
	 * @property appliesToDeliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod appliesToDeliveryMethod;

	/**
	 * Schema.org/appliesToPaymentMethod
	 * The payment method(s) to which the payment charge specification applies.
	 * @property appliesToPaymentMethod
	 * @type PaymentMethod
	 */
	public PaymentMethod appliesToPaymentMethod;

}