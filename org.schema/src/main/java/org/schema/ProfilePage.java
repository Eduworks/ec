package org.schema;

/**
 * Schema.org/ProfilePage
 * Web page type: Profile page.
 * @author schema.org
 * @class ProfilePage
 * @module org.schema
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