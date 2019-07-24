package org.schema;

/**
 * Schema.org/BookFormatType
 * The publication format of the book.
 *
 * @author schema.org
 * @class BookFormatType
 * @module org.schema
 * @extends Enumeration
 */
public class BookFormatType extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BookFormatType() {
		context = "http://schema.org/";
		type = "BookFormatType";
	}

}