package org.schema;

/**
 * Schema.org/RoofingContractor
 * A roofing contractor.
 * @author schema.org
 * @class RoofingContractor
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class RoofingContractor extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RoofingContractor()
	{
		context="http://schema.org/";
		type="RoofingContractor";
	}

}