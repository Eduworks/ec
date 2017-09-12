package org.schema;

/**
 * Schema.org/InsuranceAgency
 * An Insurance agency.
 *
 * @author schema.org
 * @class InsuranceAgency
 * @module org.schema
 * @extends FinancialService
 */
public class InsuranceAgency extends FinancialService {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public InsuranceAgency() {
		context = "http://schema.org/";
		type = "InsuranceAgency";
	}

}