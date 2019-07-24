package org.schema;

/**
 * Schema.org/BookStore
 * A bookstore.
 *
 * @author schema.org
 * @class BookStore
 * @module org.schema
 * @extends Store
 */
public class BookStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BookStore() {
		context = "http://schema.org/";
		type = "BookStore";
	}

}