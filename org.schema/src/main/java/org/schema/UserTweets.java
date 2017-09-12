package org.schema;

/**
 * Schema.org/UserTweets
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 * @author schema.org
 * @class UserTweets
 * @module org.schema
 * @extends UserInteraction
 */
public class UserTweets extends UserInteraction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UserTweets()
	{
		context="http://schema.org/";
		type="UserTweets";
	}

}