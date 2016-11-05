package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CompoundPriceSpecification
 * A compound price specification is one that bundles multiple prices that all apply in combination for different dimensions of consumption. Use the name property of the attached unit price specification for indicating the dimension of a price component (e.g. "electricity" or "final cleaning").
 * @author schema.org
 * @module schema.org
 * @class CompoundPriceSpecification
 * @extends PriceSpecification
 */
public class CompoundPriceSpecification extends PriceSpecification
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CompoundPriceSpecification()
	{
		context="http://schema.org/";
		type="CompoundPriceSpecification";
	}

	/**
	 * Schema.org/priceComponent
	 * This property links to all [[UnitPriceSpecification]] nodes that apply in parallel for the [[CompoundPriceSpecification]] node.
	 * @property priceComponent
	 * @type UnitPriceSpecification
	 */
	public UnitPriceSpecification priceComponent;

}