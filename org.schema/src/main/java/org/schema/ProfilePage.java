package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ProfilePage
 * Web page type: Profile page.
 * @author schema.org
 * @module schema.org
 * @class ProfilePage
 * @extends WebPage
 */
public class ProfilePage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ProfilePage()
	{
		context="http://schema.org/";
		type="ProfilePage";
	}

}