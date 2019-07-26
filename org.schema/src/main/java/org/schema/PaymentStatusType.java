package org.schema;

/**
 * Schema.org/PaymentStatusType
 * A specific payment status. For example, PaymentDue, PaymentComplete, etc.
 *
 * @author schema.org
 * @class PaymentStatusType
 * @module org.schema
 * @extends Enumeration
 */
public class PaymentStatusType extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PaymentStatusType() {
		context = "http://schema.org/";
		type = "PaymentStatusType";
	}

}