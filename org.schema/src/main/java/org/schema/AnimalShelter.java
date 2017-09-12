package org.schema;

/**
 * Schema.org/AnimalShelter
 * Animal shelter.
 * @author schema.org
 * @class AnimalShelter
 * @module org.schema
 * @extends LocalBusiness
 */
public class AnimalShelter extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AnimalShelter()
	{
		context="http://schema.org/";
		type="AnimalShelter";
	}

}