package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Blog
 * A blog.
 * @author schema.org
 * @class Blog
 * @module org.schema
 * @extends CreativeWork
 */
public class Blog extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Blog()
	{
		context="http://schema.org/";
		type="Blog";
	}

	/**
	 * Schema.org/blogPost
	 * A posting that is part of this blog.
	 * @property blogPost
	 * @type BlogPosting
	 */
	public BlogPosting blogPost;

	/**
	 * Schema.org/blogPosts
	 * The postings that are part of this blog.
	 * @property blogPosts
	 * @type BlogPosting
	 */
	public BlogPosting blogPosts;

}