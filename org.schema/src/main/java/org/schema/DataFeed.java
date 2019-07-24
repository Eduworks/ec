package org.schema;

/**
 * Schema.org/DataFeed
 * A single feed providing structured information about one or more entities or topics.
 *
 * @author schema.org
 * @class DataFeed
 * @module org.schema
 * @extends Dataset
 */
public class DataFeed extends Dataset {
	/**
	 * Schema.org/dataFeedElement
	 * An item within in a data feed. Data feeds may have many elements.
	 *
	 * @property dataFeedElement
	 * @type Text
	 */
	public String dataFeedElement;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DataFeed() {
		context = "http://schema.org/";
		type = "DataFeed";
	}

}