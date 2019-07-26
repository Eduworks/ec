package org.schema;

/**
 * Schema.org/MovieRentalStore
 * A movie rental store.
 *
 * @author schema.org
 * @class MovieRentalStore
 * @module org.schema
 * @extends Store
 */
public class MovieRentalStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MovieRentalStore() {
		context = "http://schema.org/";
		type = "MovieRentalStore";
	}

}