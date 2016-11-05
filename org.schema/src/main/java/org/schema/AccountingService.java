package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AccountingService
 * Accountancy business.\n\nAs a [[LocalBusiness]] it can be described as a [[provider]] of one or more [[Service]]\(s).
      
 * @author schema.org
 * @module schema.org
 * @class AccountingService
 * @extends FinancialService
 */
public class AccountingService extends FinancialService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AccountingService()
	{
		context="http://schema.org/";
		type="AccountingService";
	}

}