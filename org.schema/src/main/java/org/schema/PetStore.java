package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PetStore
 * A pet store.
 * @author schema.org
 * @module schema.org
 * @class PetStore
 * @extends Store
 */
public class PetStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PetStore()
	{
		context="http://schema.org/";
		type="PetStore";
	}

}