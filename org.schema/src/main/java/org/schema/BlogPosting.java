package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BlogPosting
 * A blog post.
 * @author schema.org
 * @module schema.org
 * @class BlogPosting
 * @extends SocialMediaPosting
 */
public class BlogPosting extends SocialMediaPosting
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BlogPosting()
	{
		context="http://schema.org/";
		type="BlogPosting";
	}

}