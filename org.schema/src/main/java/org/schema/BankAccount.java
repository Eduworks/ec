package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BankAccount
 * A product or service offered by a bank whereby one may deposit, withdraw or transfer money and in some cases be paid interest.
 * @author schema.org
 * @module schema.org
 * @class BankAccount
 * @extends FinancialProduct
 */
public class BankAccount extends FinancialProduct
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BankAccount()
	{
		context="http://schema.org/";
		type="BankAccount";
	}

}