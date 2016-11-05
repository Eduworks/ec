package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BookmarkAction
 * An agent bookmarks/flags/labels/tags/marks an object.
 * @author schema.org
 * @module schema.org
 * @class BookmarkAction
 * @extends OrganizeAction
 */
public class BookmarkAction extends OrganizeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BookmarkAction()
	{
		context="http://schema.org/";
		type="BookmarkAction";
	}

}