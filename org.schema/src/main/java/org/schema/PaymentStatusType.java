package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PaymentStatusType
 * A specific payment status. For example, PaymentDue, PaymentComplete, etc.
 * @author schema.org
 * @module schema.org
 * @class PaymentStatusType
 * @extends Enumeration
 */
public class PaymentStatusType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PaymentStatusType()
	{
		context="http://schema.org/";
		type="PaymentStatusType";
	}

}