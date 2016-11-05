package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SpreadsheetDigitalDocument
 * A spreadsheet file.
 * @author schema.org
 * @module schema.org
 * @class SpreadsheetDigitalDocument
 * @extends DigitalDocument
 */
public class SpreadsheetDigitalDocument extends DigitalDocument
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SpreadsheetDigitalDocument()
	{
		context="http://schema.org/";
		type="SpreadsheetDigitalDocument";
	}

}