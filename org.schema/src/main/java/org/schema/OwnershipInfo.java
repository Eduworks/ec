package org.schema;

/**
 * Schema.org/OwnershipInfo
 * A structured value providing information about when a certain organization or person owned a certain product.
 *
 * @author schema.org
 * @class OwnershipInfo
 * @module org.schema
 * @extends StructuredValue
 */
public class OwnershipInfo extends StructuredValue {
	/**
	 * Schema.org/typeOfGood
	 * The product that this structured value is referring to.
	 *
	 * @property typeOfGood
	 * @type Service
	 */
	public Service typeOfGood;
	/**
	 * Schema.org/ownedFrom
	 * The date and time of obtaining the product.
	 *
	 * @property ownedFrom
	 * @type DateTime
	 */
	public String ownedFrom;
	/**
	 * Schema.org/ownedThrough
	 * The date and time of giving up ownership on the product.
	 *
	 * @property ownedThrough
	 * @type DateTime
	 */
	public String ownedThrough;
	/**
	 * Schema.org/acquiredFrom
	 * The organization or person from which the product was acquired.
	 *
	 * @property acquiredFrom
	 * @type Person
	 */
	public Person acquiredFrom;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OwnershipInfo() {
		context = "http://schema.org/";
		type = "OwnershipInfo";
	}

}