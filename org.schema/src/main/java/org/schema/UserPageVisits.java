package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UserPageVisits
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 * @author schema.org
 * @class UserPageVisits
 * @module org.schema
 * @extends UserInteraction
 */
public class UserPageVisits extends UserInteraction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UserPageVisits()
	{
		context="http://schema.org/";
		type="UserPageVisits";
	}

}