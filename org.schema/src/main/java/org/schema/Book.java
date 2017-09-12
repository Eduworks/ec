package org.schema;

/**
 * Schema.org/Book
 * A book.
 *
 * @author schema.org
 * @class Book
 * @module org.schema
 * @extends CreativeWork
 */
public class Book extends CreativeWork {
	/**
	 * Schema.org/illustrator
	 * The illustrator of the book.
	 *
	 * @property illustrator
	 * @type Person
	 */
	public Person illustrator;
	/**
	 * Schema.org/bookEdition
	 * The edition of the book.
	 *
	 * @property bookEdition
	 * @type Text
	 */
	public String bookEdition;
	/**
	 * Schema.org/bookFormat
	 * The format of the book.
	 *
	 * @property bookFormat
	 * @type BookFormatType
	 */
	public BookFormatType bookFormat;
	/**
	 * Schema.org/isbn
	 * The ISBN of the book.
	 *
	 * @property isbn
	 * @type Text
	 */
	public String isbn;
	/**
	 * Schema.org/numberOfPages
	 * The number of pages in the book.
	 *
	 * @property numberOfPages
	 * @type Integer
	 */
	public Integer numberOfPages;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Book() {
		context = "http://schema.org/";
		type = "Book";
	}

}