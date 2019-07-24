package org.schema;

/**
 * Schema.org/MusicStore
 * A music store.
 *
 * @author schema.org
 * @class MusicStore
 * @module org.schema
 * @extends Store
 */
public class MusicStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MusicStore() {
		context = "http://schema.org/";
		type = "MusicStore";
	}

}