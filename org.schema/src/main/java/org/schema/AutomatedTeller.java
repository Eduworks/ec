package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutomatedTeller
 * ATM/cash machine.
 * @author schema.org
 * @module schema.org
 * @class AutomatedTeller
 * @extends FinancialService
 */
public class AutomatedTeller extends FinancialService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutomatedTeller()
	{
		context="http://schema.org/";
		type="AutomatedTeller";
	}

}