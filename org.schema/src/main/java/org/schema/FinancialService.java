package org.schema;

/**
 * Schema.org/FinancialService
 * Financial services business.
 *
 * @author schema.org
 * @class FinancialService
 * @module org.schema
 * @extends LocalBusiness
 */
public class FinancialService extends LocalBusiness {
	/**
	 * Schema.org/feesAndCommissionsSpecification
	 * Description of fees, commissions, and other terms applied either to a class of financial product, or by a financial service organization.
	 *
	 * @property feesAndCommissionsSpecification
	 * @type Text
	 */
	public String feesAndCommissionsSpecification;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FinancialService() {
		context = "http://schema.org/";
		type = "FinancialService";
	}

}