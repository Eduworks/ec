package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PublicationIssue
 * A part of a successively published publication such as a periodical or publication volume, often numbered, usually containing a grouping of works such as articles.\n\n[blog post](http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html).
 * @author schema.org
 * @class PublicationIssue
 * @module org.schema
 * @extends CreativeWork
 */
public class PublicationIssue extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PublicationIssue()
	{
		context="http://schema.org/";
		type="PublicationIssue";
	}

	/**
	 * Schema.org/pageStart
	 * The page on which the work starts; for example "135" or "xiii".
	 * @property pageStart
	 * @type schema,Integer | schema,Text
	 */
	public Object pageStart;

	/**
	 * Schema.org/pageEnd
	 * The page on which the work ends; for example "138" or "xvi".
	 * @property pageEnd
	 * @type schema,Integer | schema,Text
	 */
	public Object pageEnd;

	/**
	 * Schema.org/pagination
	 * Any description of pages that is not separated into pageStart and pageEnd; for example, "1-6, 9, 55" or "10-12, 46-49".
	 * @property pagination
	 * @type Text
	 */
	public String pagination;

	/**
	 * Schema.org/issueNumber
	 * Identifies the issue of publication; for example, "iii" or "2".
	 * @property issueNumber
	 * @type schema,Integer | schema,Text
	 */
	public Object issueNumber;

}