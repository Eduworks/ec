package org.schema;

/**
 * Schema.org/BlogPosting
 * A blog post.
 * @author schema.org
 * @class BlogPosting
 * @module org.schema
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