package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SearchResultsPage
 * Web page type: Search results page.
 * @author schema.org
 * @class SearchResultsPage
 * @module org.schema
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