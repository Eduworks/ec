package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SearchResultsPage
 * Web page type: Search results page.
 * @author schema.org
 * @module schema.org
 * @class SearchResultsPage
 * @extends WebPage
 */
public class SearchResultsPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SearchResultsPage()
	{
		context="http://schema.org/";
		type="SearchResultsPage";
	}

}