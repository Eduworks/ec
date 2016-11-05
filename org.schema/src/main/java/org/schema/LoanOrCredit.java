package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LoanOrCredit
 * A financial product for the loaning of an amount of money under agreed terms and charges.
 * @author schema.org
 * @module schema.org
 * @class LoanOrCredit
 * @extends FinancialProduct
 */
public class LoanOrCredit extends FinancialProduct
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LoanOrCredit()
	{
		context="http://schema.org/";
		type="LoanOrCredit";
	}

	/**
	 * Schema.org/amount
	 * The amount of money.
	 * @property amount
	 * @type schema,MonetaryAmount | schema,Number	 */
	public Object amount;

	/**
	 * Schema.org/requiredCollateral
	 * Assets required to secure loan or credit repayments. It may take form of third party pledge, goods, financial instruments (cash, securities, etc.)
	 * @property requiredCollateral
	 * @type schema,Thing | schema,Text	 */
	public Object requiredCollateral;

	/**
	 * Schema.org/loanTerm
	 * The duration of the loan or credit agreement.
	 * @property loanTerm
	 * @type QuantitativeValue
	 */
	public QuantitativeValue loanTerm;

}