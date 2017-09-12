package org.schema;

/**
 * Schema.org/SocialMediaPosting
 * A post to a social media platform, including blog posts, tweets, Facebook posts, etc.
 * @author schema.org
 * @class SocialMediaPosting
 * @module org.schema
 * @extends Article
 */
public class SocialMediaPosting extends Article
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SocialMediaPosting()
	{
		context="http://schema.org/";
		type="SocialMediaPosting";
	}

	/**
	 * Schema.org/sharedContent
	 * A CreativeWork such as an image, video, or audio clip shared as part of this posting.
	 * @property sharedContent
	 * @type CreativeWork
	 */
	public CreativeWork sharedContent;

}