package org.schema;

/**
 * Schema.org/NailSalon
 * A nail salon.
 * @author schema.org
 * @class NailSalon
 * @module org.schema
 * @extends HealthAndBeautyBusiness
 */
public class NailSalon extends HealthAndBeautyBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public NailSalon()
	{
		context="http://schema.org/";
		type="NailSalon";
	}

}