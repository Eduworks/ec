package org.schema;

/**
 * Schema.org/FinancialProduct
 * A product provided to consumers and businesses by financial institutions such as banks, insurance companies, brokerage firms, consumer finance companies, and investment companies which comprise the financial services industry.
 *
 * @author schema.org
 * @class FinancialProduct
 * @module org.schema
 * @extends Service
 */
public class FinancialProduct extends Service {
	/**
	 * Schema.org/feesAndCommissionsSpecification
	 * Description of fees, commissions, and other terms applied either to a class of financial product, or by a financial service organization.
	 *
	 * @property feesAndCommissionsSpecification
	 * @type schema, URL | schema,Text
	 */
	public Object feesAndCommissionsSpecification;
	/**
	 * Schema.org/annualPercentageRate
	 * The annual rate that is charged for borrowing (or made by investing), expressed as a single percentage number that represents the actual yearly cost of funds over the term of a loan. This includes any fees or additional costs associated with the transaction.
	 *
	 * @property annualPercentageRate
	 * @type schema, Number | schema,QuantitativeValue
	 */
	public Object annualPercentageRate;
	/**
	 * Schema.org/interestRate
	 * The interest rate, charged or paid, applicable to the financial product. Note: This is different from the calculated annualPercentageRate.
	 *
	 * @property interestRate
	 * @type schema, Number | schema,QuantitativeValue
	 */
	public Object interestRate;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FinancialProduct() {
		context = "http://schema.org/";
		type = "FinancialProduct";
	}

}