package org.schema;

/**
 * Schema.org/QAPage
 * A QAPage is a WebPage focussed on a specific Question and its Answer(s), e.g. in a question answering site or documenting Frequently Asked Questions (FAQs).
 * @author schema.org
 * @class QAPage
 * @module org.schema
 * @extends WebPage
 */
public class QAPage extends WebPage
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public QAPage()
	{
		context="http://schema.org/";
		type="QAPage";
	}

}