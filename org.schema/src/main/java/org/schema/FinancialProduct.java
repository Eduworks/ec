package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/FinancialProduct
 * A product provided to consumers and businesses by financial institutions such as banks, insurance companies, brokerage firms, consumer finance companies, and investment companies which comprise the financial services industry.
 * @author schema.org
 * @module schema.org
 * @class FinancialProduct
 * @extends Service
 */
public class FinancialProduct extends Service
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FinancialProduct()
	{
		context="http://schema.org/";
		type="FinancialProduct";
	}

	/**
	 * Schema.org/feesAndCommissionsSpecification
	 * Description of fees, commissions, and other terms applied either to a class of financial product, or by a financial service organization.
	 * @property feesAndCommissionsSpecification
	 * @type schema,Text | schema,URL	 */
	public Object feesAndCommissionsSpecification;

	/**
	 * Schema.org/annualPercentageRate
	 * The annual rate that is charged for borrowing (or made by investing), expressed as a single percentage number that represents the actual yearly cost of funds over the term of a loan. This includes any fees or additional costs associated with the transaction.
	 * @property annualPercentageRate
	 * @type schema,QuantitativeValue | schema,Number	 */
	public Object annualPercentageRate;

	/**
	 * Schema.org/interestRate
	 * The interest rate, charged or paid, applicable to the financial product. Note: This is different from the calculated annualPercentageRate.
	 * @property interestRate
	 * @type schema,QuantitativeValue | schema,Number	 */
	public Object interestRate;

}