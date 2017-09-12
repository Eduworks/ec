package org.schema;

/**
 * Schema.org/Article
 * An article, such as a news article or piece of investigative report. Newspapers and magazines have articles of many different types and this is intended to cover them all.\n\nSee also [blog post](http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html).
 * @author schema.org
 * @class Article
 * @module org.schema
 * @extends CreativeWork
 */
public class Article extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Article()
	{
		context="http://schema.org/";
		type="Article";
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
	 * Schema.org/articleSection
	 * Articles may belong to one or more 'sections' in a magazine or newspaper, such as Sports, Lifestyle, etc.
	 * @property articleSection
	 * @type Text
	 */
	public String articleSection;

	/**
	 * Schema.org/articleBody
	 * The actual body of the article.
	 * @property articleBody
	 * @type Text
	 */
	public String articleBody;

	/**
	 * Schema.org/wordCount
	 * The number of words in the text of the Article.
	 * @property wordCount
	 * @type Integer
	 */
	public Integer wordCount;

	/**
	 * Schema.org/pagination
	 * Any description of pages that is not separated into pageStart and pageEnd; for example, "1-6, 9, 55" or "10-12, 46-49".
	 * @property pagination
	 * @type Text
	 */
	public String pagination;

}