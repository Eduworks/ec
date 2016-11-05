package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UnitPriceSpecification
 * The price asked for a given offer by the respective organization or person.
 * @author schema.org
 * @module schema.org
 * @class UnitPriceSpecification
 * @extends PriceSpecification
 */
public class UnitPriceSpecification extends PriceSpecification
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UnitPriceSpecification()
	{
		context="http://schema.org/";
		type="UnitPriceSpecification";
	}

	/**
	 * Schema.org/billingIncrement
	 * This property specifies the minimal quantity and rounding increment that will be the basis for the billing. The unit of measurement is specified by the unitCode property.
	 * @property billingIncrement
	 * @type Number
	 */
	public Double billingIncrement;

	/**
	 * Schema.org/priceType
	 * A short text or acronym indicating multiple price specifications for the same offer, e.g. SRP for the suggested retail price or INVOICE for the invoice price, mostly used in the car industry.
	 * @property priceType
	 * @type Text
	 */
	public String priceType;

	/**
	 * Schema.org/unitCode
	 * The unit of measurement given using the UN/CEFACT Common Code (3 characters) or a URL. Other codes than the UN/CEFACT Common Code may be used with a prefix followed by a colon.
	 * @property unitCode
	 * @type schema,Text | schema,URL	 */
	public Object unitCode;

	/**
	 * Schema.org/referenceQuantity
	 * The reference quantity for which a certain price applies, e.g. 1 EUR per 4 kWh of electricity. This property is a replacement for unitOfMeasurement for the advanced cases where the price does not relate to a standard unit.
	 * @property referenceQuantity
	 * @type QuantitativeValue
	 */
	public QuantitativeValue referenceQuantity;

	/**
	 * Schema.org/unitText
	 * A string or text indicating the unit of measurement. Useful if you cannot provide a standard unit code for
<a href='unitCode'>unitCode</a>.
	 * @property unitText
	 * @type Text
	 */
	public String unitText;

}