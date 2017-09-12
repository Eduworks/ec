package org.schema;

/**
 * Schema.org/Table
 * A table on a Web page.
 *
 * @author schema.org
 * @class Table
 * @module org.schema
 * @extends WebPageElement
 */
public class Table extends WebPageElement {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Table() {
		context = "http://schema.org/";
		type = "Table";
	}

}