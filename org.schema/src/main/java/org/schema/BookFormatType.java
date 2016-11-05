package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BookFormatType
 * The publication format of the book.
 * @author schema.org
 * @module schema.org
 * @class BookFormatType
 * @extends Enumeration
 */
public class BookFormatType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BookFormatType()
	{
		context="http://schema.org/";
		type="BookFormatType";
	}

}