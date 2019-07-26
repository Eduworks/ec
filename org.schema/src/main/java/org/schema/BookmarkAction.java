package org.schema;

/**
 * Schema.org/BookmarkAction
 * An agent bookmarks/flags/labels/tags/marks an object.
 *
 * @author schema.org
 * @class BookmarkAction
 * @module org.schema
 * @extends OrganizeAction
 */
public class BookmarkAction extends OrganizeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BookmarkAction() {
		context = "http://schema.org/";
		type = "BookmarkAction";
	}

}