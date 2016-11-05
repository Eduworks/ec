package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UserLikes
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 * @author schema.org
 * @module schema.org
 * @class UserLikes
 * @extends UserInteraction
 */
public class UserLikes extends UserInteraction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UserLikes()
	{
		context="http://schema.org/";
		type="UserLikes";
	}

}