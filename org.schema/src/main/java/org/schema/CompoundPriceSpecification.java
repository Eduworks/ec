package org.schema;

/**
 * Schema.org/CompoundPriceSpecification
 * A compound price specification is one that bundles multiple prices that all apply in combination for different dimensions of consumption. Use the name property of the attached unit price specification for indicating the dimension of a price component (e.g. "electricity" or "final cleaning").
 *
 * @author schema.org
 * @class CompoundPriceSpecification
 * @module org.schema
 * @extends PriceSpecification
 */
public class CompoundPriceSpecification extends PriceSpecification {
	/**
	 * Schema.org/priceComponent
	 * This property links to all [[UnitPriceSpecification]] nodes that apply in parallel for the [[CompoundPriceSpecification]] node.
	 *
	 * @property priceComponent
	 * @type UnitPriceSpecification
	 */
	public UnitPriceSpecification priceComponent;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CompoundPriceSpecification() {
		context = "http://schema.org/";
		type = "CompoundPriceSpecification";
	}

}