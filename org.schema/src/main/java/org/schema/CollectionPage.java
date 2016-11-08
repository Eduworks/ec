package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CollectionPage
 * Web page type: Collection page.
 * @author schema.org
 * @class CollectionPage
 * @module org.schema
 * @extends WebPage
 */
public class CollectionPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CollectionPage()
	{
		context="http://schema.org/";
		type="CollectionPage";
	}

}