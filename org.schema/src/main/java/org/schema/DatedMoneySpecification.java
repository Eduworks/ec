package org.schema;

/**
 * Schema.org/DatedMoneySpecification
 * A DatedMoneySpecification represents monetary values with optional start and end dates. For example, this could represent an employee's salary over a specific period of time. __Note:__ This type has been superseded by [[MonetaryAmount]] use of that type is recommended
 *
 * @author schema.org
 * @class DatedMoneySpecification
 * @module org.schema
 * @extends StructuredValue
 */
public class DatedMoneySpecification extends StructuredValue {
	/**
	 * Schema.org/endDate
	 * The end date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 *
	 * @property endDate
	 * @type DateTime
	 */
	public String endDate;
	/**
	 * Schema.org/amount
	 * The amount of money.
	 *
	 * @property amount
	 * @type Number
	 */
	public Double amount;
	/**
	 * Schema.org/startDate
	 * The start date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 *
	 * @property startDate
	 * @type Date
	 */
	public String startDate;
	/**
	 * Schema.org/currency
	 * The currency in which the monetary amount is expressed (in 3-letter [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) format).
	 *
	 * @property currency
	 * @type Text
	 */
	public String currency;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DatedMoneySpecification() {
		context = "http://schema.org/";
		type = "DatedMoneySpecification";
	}

}