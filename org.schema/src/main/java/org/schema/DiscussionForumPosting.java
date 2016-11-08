package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DiscussionForumPosting
 * A posting to a discussion forum.
 * @author schema.org
 * @class DiscussionForumPosting
 * @module org.schema
 * @extends SocialMediaPosting
 */
public class DiscussionForumPosting extends SocialMediaPosting
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DiscussionForumPosting()
	{
		context="http://schema.org/";
		type="DiscussionForumPosting";
	}

}