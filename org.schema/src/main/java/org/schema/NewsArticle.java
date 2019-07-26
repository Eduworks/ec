package org.schema;

/**
 * Schema.org/NewsArticle
 * A news article.
 *
 * @author schema.org
 * @class NewsArticle
 * @module org.schema
 * @extends Article
 */
public class NewsArticle extends Article {
	/**
	 * Schema.org/printColumn
	 * The number of the column in which the NewsArticle appears in the print edition.
	 *
	 * @property printColumn
	 * @type Text
	 */
	public String printColumn;
	/**
	 * Schema.org/printEdition
	 * The edition of the print product in which the NewsArticle appears.
	 *
	 * @property printEdition
	 * @type Text
	 */
	public String printEdition;
	/**
	 * Schema.org/printSection
	 * If this NewsArticle appears in print, this field indicates the print section in which the article appeared.
	 *
	 * @property printSection
	 * @type Text
	 */
	public String printSection;
	/**
	 * Schema.org/printPage
	 * If this NewsArticle appears in print, this field indicates the name of the page on which the article is found. Please note that this field is intended for the exact page name (e.g. A5, B18).
	 *
	 * @property printPage
	 * @type Text
	 */
	public String printPage;
	/**
	 * Schema.org/dateline
	 * The location where the NewsArticle was produced.
	 *
	 * @property dateline
	 * @type Text
	 */
	public String dateline;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public NewsArticle() {
		context = "http://schema.org/";
		type = "NewsArticle";
	}

}