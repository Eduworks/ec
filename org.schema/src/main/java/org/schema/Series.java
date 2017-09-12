package org.schema;

/**
 * Schema.org/Series
 * <p>
 * A Series in schema.org is a group of related items, typically but not necessarily of the same kind.
 *
 * @author schema.org
 * @class Series
 * @module org.schema
 * @extends CreativeWork
 */
public class Series extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Series() {
		context = "http://schema.org/";
		type = "Series";
	}

}