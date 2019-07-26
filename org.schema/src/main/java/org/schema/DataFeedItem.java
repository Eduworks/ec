package org.schema;

/**
 * Schema.org/DataFeedItem
 * A single item within a larger data feed.
 *
 * @author schema.org
 * @class DataFeedItem
 * @module org.schema
 * @extends Intangible
 */
public class DataFeedItem extends Intangible {
	/**
	 * Schema.org/dateModified
	 * The date on which the CreativeWork was most recently modified or when the item's entry was modified within a DataFeed.
	 *
	 * @property dateModified
	 * @type DateTime
	 */
	public String dateModified;
	/**
	 * Schema.org/dateDeleted
	 * The datetime the item was removed from the DataFeed.
	 *
	 * @property dateDeleted
	 * @type DateTime
	 */
	public String dateDeleted;
	/**
	 * Schema.org/dateCreated
	 * The date on which the CreativeWork was created or the item was added to a DataFeed.
	 *
	 * @property dateCreated
	 * @type Date
	 */
	public String dateCreated;
	/**
	 * Schema.org/item
	 * An entity represented by an entry in a list or data feed (e.g. an 'artist' in a list of 'artists')’.
	 *
	 * @property item
	 * @type Thing
	 */
	public Thing item;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DataFeedItem() {
		context = "http://schema.org/";
		type = "DataFeedItem";
	}

}