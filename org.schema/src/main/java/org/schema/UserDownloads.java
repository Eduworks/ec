package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UserDownloads
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 * @author schema.org
 * @class UserDownloads
 * @module org.schema
 * @extends UserInteraction
 */
public class UserDownloads extends UserInteraction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UserDownloads()
	{
		context="http://schema.org/";
		type="UserDownloads";
	}

}