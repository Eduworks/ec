package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InsuranceAgency
 * An Insurance agency.
 * @author schema.org
 * @module schema.org
 * @class InsuranceAgency
 * @extends FinancialService
 */
public class InsuranceAgency extends FinancialService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InsuranceAgency()
	{
		context="http://schema.org/";
		type="InsuranceAgency";
	}

}