package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ApartmentComplex
 * Residence type: Apartment complex.
 * @author schema.org
 * @module schema.org
 * @class ApartmentComplex
 * @extends Residence
 */
public class ApartmentComplex extends Residence
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ApartmentComplex()
	{
		context="http://schema.org/";
		type="ApartmentComplex";
	}

}