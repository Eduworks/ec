package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DataFeed
 * A single feed providing structured information about one or more entities or topics.
 * @author schema.org
 * @module schema.org
 * @class DataFeed
 * @extends Dataset
 */
public class DataFeed extends Dataset
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DataFeed()
	{
		context="http://schema.org/";
		type="DataFeed";
	}

	/**
	 * Schema.org/dataFeedElement
	 * An item within in a data feed. Data feeds may have many elements.
	 * @property dataFeedElement
	 * @type schema,Thing | schema,Text | schema,DataFeedItem	 */
	public Object dataFeedElement;

}