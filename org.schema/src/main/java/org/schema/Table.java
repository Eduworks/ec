package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Table
 * A table on a Web page.
 * @author schema.org
 * @class Table
 * @module org.schema
 * @extends WebPageElement
 */
public class Table extends WebPageElement
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Table()
	{
		context="http://schema.org/";
		type="Table";
	}

}