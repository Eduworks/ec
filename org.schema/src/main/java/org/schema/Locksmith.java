package org.schema;

/**
 * Schema.org/Locksmith
 * A locksmith.
 * @author schema.org
 * @class Locksmith
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class Locksmith extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Locksmith()
	{
		context="http://schema.org/";
		type="Locksmith";
	}

}