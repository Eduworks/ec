package org.schema;

/**
 * Schema.org/TypeAndQuantityNode
 * A structured value indicating the quantity, unit of measurement, and business function of goods included in a bundle offer.
 *
 * @author schema.org
 * @class TypeAndQuantityNode
 * @module org.schema
 * @extends StructuredValue
 */
public class TypeAndQuantityNode extends StructuredValue {
	/**
	 * Schema.org/unitCode
	 * The unit of measurement given using the UN/CEFACT Common Code (3 characters) or a URL. Other codes than the UN/CEFACT Common Code may be used with a prefix followed by a colon.
	 *
	 * @property unitCode
	 * @type Text
	 */
	public String unitCode;
	/**
	 * Schema.org/typeOfGood
	 * The product that this structured value is referring to.
	 *
	 * @property typeOfGood
	 * @type Service
	 */
	public Service typeOfGood;
	/**
	 * Schema.org/amountOfThisGood
	 * The quantity of the goods included in the offer.
	 *
	 * @property amountOfThisGood
	 * @type Number
	 */
	public Double amountOfThisGood;
	/**
	 * Schema.org/unitText
	 * A string or text indicating the unit of measurement. Useful if you cannot provide a standard unit code for
	 * <a href='unitCode'>unitCode</a>.
	 *
	 * @property unitText
	 * @type Text
	 */
	public String unitText;
	/**
	 * Schema.org/businessFunction
	 * The business function (e.g. sell, lease, repair, dispose) of the offer or component of a bundle (TypeAndQuantityNode). The default is http://purl.org/goodrelations/v1#Sell.
	 *
	 * @property businessFunction
	 * @type BusinessFunction
	 */
	public BusinessFunction businessFunction;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TypeAndQuantityNode() {
		context = "http://schema.org/";
		type = "TypeAndQuantityNode";
	}

}