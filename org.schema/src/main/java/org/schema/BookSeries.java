package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BookSeries
 * A series of books. Included books can be indicated with the hasPart property.
 * @author schema.org
 * @class BookSeries
 * @module org.schema
 * @extends CreativeWorkSeries
 */
public class BookSeries extends CreativeWorkSeries
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BookSeries()
	{
		context="http://schema.org/";
		type="BookSeries";
	}

}