package org.schema;

/**
 * Schema.org/PaymentChargeSpecification
 * The costs of settling the payment using a particular payment method.
 *
 * @author schema.org
 * @class PaymentChargeSpecification
 * @module org.schema
 * @extends PriceSpecification
 */
public class PaymentChargeSpecification extends PriceSpecification {
	/**
	 * Schema.org/appliesToPaymentMethod
	 * The payment method(s) to which the payment charge specification applies.
	 *
	 * @property appliesToPaymentMethod
	 * @type PaymentMethod
	 */
	public PaymentMethod appliesToPaymentMethod;
	/**
	 * Schema.org/appliesToDeliveryMethod
	 * The delivery method(s) to which the delivery charge or payment charge specification applies.
	 *
	 * @property appliesToDeliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod appliesToDeliveryMethod;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PaymentChargeSpecification() {
		context = "http://schema.org/";
		type = "PaymentChargeSpecification";
	}

}