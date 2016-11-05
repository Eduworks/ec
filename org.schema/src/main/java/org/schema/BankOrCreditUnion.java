package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BankOrCreditUnion
 * Bank or credit union.
 * @author schema.org
 * @module schema.org
 * @class BankOrCreditUnion
 * @extends FinancialService
 */
public class BankOrCreditUnion extends FinancialService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BankOrCreditUnion()
	{
		context="http://schema.org/";
		type="BankOrCreditUnion";
	}

}