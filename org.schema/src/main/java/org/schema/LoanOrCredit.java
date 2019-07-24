package org.schema;

/**
 * Schema.org/LoanOrCredit
 * A financial product for the loaning of an amount of money under agreed terms and charges.
 *
 * @author schema.org
 * @class LoanOrCredit
 * @module org.schema
 * @extends FinancialProduct
 */
public class LoanOrCredit extends FinancialProduct {
	/**
	 * Schema.org/loanTerm
	 * The duration of the loan or credit agreement.
	 *
	 * @property loanTerm
	 * @type QuantitativeValue
	 */
	public QuantitativeValue loanTerm;
	/**
	 * Schema.org/amount
	 * The amount of money.
	 *
	 * @property amount
	 * @type Number
	 */
	public Double amount;
	/**
	 * Schema.org/requiredCollateral
	 * Assets required to secure loan or credit repayments. It may take form of third party pledge, goods, financial instruments (cash, securities, etc.)
	 *
	 * @property requiredCollateral
	 * @type Thing
	 */
	public Thing requiredCollateral;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LoanOrCredit() {
		context = "http://schema.org/";
		type = "LoanOrCredit";
	}

}