package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MovieRentalStore
 * A movie rental store.
 * @author schema.org
 * @module schema.org
 * @class MovieRentalStore
 * @extends Store
 */
public class MovieRentalStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MovieRentalStore()
	{
		context="http://schema.org/";
		type="MovieRentalStore";
	}

}