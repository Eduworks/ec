package org.schema;

/**
 * Schema.org/LocalBusiness
 * A particular physical business or branch of an organization. Examples of LocalBusiness include a restaurant, a particular branch of a restaurant chain, a branch of a bank, a medical practice, a club, a bowling alley, etc.
 *
 * @author schema.org
 * @class LocalBusiness
 * @module org.schema
 * @extends Organization
 */
public class LocalBusiness extends Organization {
	/**
	 * Schema.org/priceRange
	 * The price range of the business, for example ```$$$```.
	 *
	 * @property priceRange
	 * @type Text
	 */
	public String priceRange;
	/**
	 * Schema.org/branchOf
	 * The larger organization that this local business is a branch of, if any. Not to be confused with (anatomical)[[branch]].
	 *
	 * @property branchOf
	 * @type Organization
	 */
	public Organization branchOf;
	/**
	 * Schema.org/paymentAccepted
	 * Cash, credit card, etc.
	 *
	 * @property paymentAccepted
	 * @type Text
	 */
	public String paymentAccepted;
	/**
	 * Schema.org/openingHours
	 * The general opening hours for a business. Opening hours can be specified as a weekly time range, starting with days, then times per day. Multiple days can be listed with commas ',' separating each day. Day or time ranges are specified using a hyphen '-'.\n\n* Days are specified using the following two-letter combinations: ```Mo```, ```Tu```, ```We```, ```Th```, ```Fr```, ```Sa```, ```Su```.\n* Times are specified using 24:00 time. For example, 3pm is specified as ```15:00```. \n* Here is an example: <code>&lt;time itemprop="openingHours" datetime=&quot;Tu,Th 16:00-20:00&quot;&gt;Tuesdays and Thursdays 4-8pm&lt;/time&gt;</code>.\n* If a business is open 7 days a week, then it can be specified as <code>&lt;time itemprop=&quot;openingHours&quot; datetime=&quot;Mo-Su&quot;&gt;Monday through Sunday, all day&lt;/time&gt;</code>.
	 *
	 * @property openingHours
	 * @type Text
	 */
	public String openingHours;
	/**
	 * Schema.org/currenciesAccepted
	 * The currency accepted (in [ISO 4217 currency format](http://en.wikipedia.org/wiki/ISO_4217)).
	 *
	 * @property currenciesAccepted
	 * @type Text
	 */
	public String currenciesAccepted;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LocalBusiness() {
		context = "http://schema.org/";
		type = "LocalBusiness";
	}

}