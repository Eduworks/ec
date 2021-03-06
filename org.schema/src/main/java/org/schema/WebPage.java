package org.schema;

/**
 * Schema.org/WebPage
 * A web page. Every web page is implicitly assumed to be declared to be of type WebPage, so the various properties about that webpage, such as <code>breadcrumb</code> may be used. We recommend explicit declaration if these properties are specified, but if they are found outside of an itemscope, they will be assumed to be about the page.
 *
 * @author schema.org
 * @class WebPage
 * @module org.schema
 * @extends CreativeWork
 */
public class WebPage extends CreativeWork {
	/**
	 * Schema.org/lastReviewed
	 * Date on which the content on this web page was last reviewed for accuracy and/or completeness.
	 *
	 * @property lastReviewed
	 * @type Date
	 */
	public String lastReviewed;
	/**
	 * Schema.org/breadcrumb
	 * A set of links that can help a user understand and navigate a website hierarchy.
	 *
	 * @property breadcrumb
	 * @type Text
	 */
	public String breadcrumb;
	/**
	 * Schema.org/significantLink
	 * One of the more significant URLs on the page. Typically, these are the non-navigation links that are clicked on the most.
	 *
	 * @property significantLink
	 * @type URL
	 */
	public String significantLink;
	/**
	 * Schema.org/relatedLink
	 * A link related to this web page, for example to other related web pages.
	 *
	 * @property relatedLink
	 * @type URL
	 */
	public String relatedLink;
	/**
	 * Schema.org/mainContentOfPage
	 * Indicates if this web page element is the main subject of the page.
	 *
	 * @property mainContentOfPage
	 * @type WebPageElement
	 */
	public WebPageElement mainContentOfPage;
	/**
	 * Schema.org/reviewedBy
	 * People or organizations that have reviewed the content on this web page for accuracy and/or completeness.
	 *
	 * @property reviewedBy
	 * @type Organization
	 */
	public Organization reviewedBy;
	/**
	 * Schema.org/primaryImageOfPage
	 * Indicates the main image on the page.
	 *
	 * @property primaryImageOfPage
	 * @type ImageObject
	 */
	public ImageObject primaryImageOfPage;
	/**
	 * Schema.org/significantLinks
	 * The most significant URLs on the page. Typically, these are the non-navigation links that are clicked on the most.
	 *
	 * @property significantLinks
	 * @type URL
	 */
	public String significantLinks;
	/**
	 * Schema.org/specialty
	 * One of the domain specialities to which this web page's content applies.
	 *
	 * @property specialty
	 * @type Specialty
	 */
	public Specialty specialty;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WebPage() {
		context = "http://schema.org/";
		type = "WebPage";
	}

}