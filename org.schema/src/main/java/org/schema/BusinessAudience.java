package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BusinessAudience
 * A set of characteristics belonging to businesses, e.g. who compose an item's target audience.
 * @author schema.org
 * @module schema.org
 * @class BusinessAudience
 * @extends Audience
 */
public class BusinessAudience extends Audience
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BusinessAudience()
	{
		context="http://schema.org/";
		type="BusinessAudience";
	}

	/**
	 * Schema.org/yearlyRevenue
	 * The size of the business in annual revenue.
	 * @property yearlyRevenue
	 * @type QuantitativeValue
	 */
	public QuantitativeValue yearlyRevenue;

	/**
	 * Schema.org/numberOfEmployees
	 * The number of employees in an organization e.g. business.
	 * @property numberOfEmployees
	 * @type QuantitativeValue
	 */
	public QuantitativeValue numberOfEmployees;

	/**
	 * Schema.org/yearsInOperation
	 * The age of the business.
	 * @property yearsInOperation
	 * @type QuantitativeValue
	 */
	public QuantitativeValue yearsInOperation;

}