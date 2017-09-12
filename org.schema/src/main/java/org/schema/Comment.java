package org.schema;

/**
 * Schema.org/Comment
 * A comment on an item - for example, a comment on a blog post. The comment's content is expressed via the [[text]] property, and its topic via [[about]], properties shared with all CreativeWorks.
 * @author schema.org
 * @class Comment
 * @module org.schema
 * @extends CreativeWork
 */
public class Comment extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Comment()
	{
		context="http://schema.org/";
		type="Comment";
	}

	/**
	 * Schema.org/upvoteCount
	 * The number of upvotes this question, answer or comment has received from the community.
	 * @property upvoteCount
	 * @type Integer
	 */
	public Integer upvoteCount;

	/**
	 * Schema.org/downvoteCount
	 * The number of downvotes this question, answer or comment has received from the community.
	 * @property downvoteCount
	 * @type Integer
	 */
	public Integer downvoteCount;

	/**
	 * Schema.org/parentItem
	 * The parent of a question, answer or item in general.
	 * @property parentItem
	 * @type Question
	 */
	public Question parentItem;

}