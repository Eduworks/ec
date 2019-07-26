package org.schema;

/**
 * Schema.org/SpreadsheetDigitalDocument
 * A spreadsheet file.
 *
 * @author schema.org
 * @class SpreadsheetDigitalDocument
 * @module org.schema
 * @extends DigitalDocument
 */
public class SpreadsheetDigitalDocument extends DigitalDocument {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SpreadsheetDigitalDocument() {
		context = "http://schema.org/";
		type = "SpreadsheetDigitalDocument";
	}

}