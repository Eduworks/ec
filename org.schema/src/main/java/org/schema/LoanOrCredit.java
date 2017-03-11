package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LoanOrCredit
 * A financial product for the loaning of an amount of money under agreed terms and charges.
 * @author schema.org
 * @class LoanOrCredit
 * @module org.schema
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
	 * Schema.org/requiredCollateral
	 * Assets required to secure loan or credit repayments. It may take form of third party pledge, goods, financial instruments (cash, securities, etc.)
	 * @property requiredCollateral
	 * @type schema,Text | schema,Thing
	 */
	public Object requiredCollateral;

	/**
	 * Schema.org/amount
	 * The amount of money.
	 * @property amount
	 * @type schema,Number | schema,MonetaryAmount
	 */
	public Object amount;

	/**
	 * Schema.org/loanTerm
	 * The duration of the loan or credit agreement.
	 * @property loanTerm
	 * @type QuantitativeValue
	 */
	public QuantitativeValue loanTerm;

}