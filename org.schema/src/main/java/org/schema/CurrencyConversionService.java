package org.schema;

/**
 * Schema.org/CurrencyConversionService
 * A service to convert funds from one currency to another currency.
 * @author schema.org
 * @class CurrencyConversionService
 * @module org.schema
 * @extends FinancialProduct
 */
public class CurrencyConversionService extends FinancialProduct
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CurrencyConversionService()
	{
		context="http://schema.org/";
		type="CurrencyConversionService";
	}

}