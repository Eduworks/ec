package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

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