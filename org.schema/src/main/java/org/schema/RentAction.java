package org.schema;

/**
 * Schema.org/RentAction
 * The act of giving money in return for temporary use, but not ownership, of an object such as a vehicle or property. For example, an agent rents a property from a landlord in exchange for a periodic payment.
 * @author schema.org
 * @class RentAction
 * @module org.schema
 * @extends TradeAction
 */
public class RentAction extends TradeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RentAction()
	{
		context="http://schema.org/";
		type="RentAction";
	}

	/**
	 * Schema.org/realEstateAgent
	 * A sub property of participant. The real estate agent involved in the action.
	 * @property realEstateAgent
	 * @type RealEstateAgent
	 */
	public RealEstateAgent realEstateAgent;

	/**
	 * Schema.org/landlord
	 * A sub property of participant. The owner of the real estate property.
	 * @property landlord
	 * @type schema,Organization | schema,Person
	 */
	public Object landlord;

}