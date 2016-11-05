package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AnimalShelter
 * Animal shelter.
 * @author schema.org
 * @module schema.org
 * @class AnimalShelter
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