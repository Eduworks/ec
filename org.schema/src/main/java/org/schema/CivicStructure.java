package org.schema;

/**
 * Schema.org/CivicStructure
 * A public structure, such as a town hall or concert hall.
 *
 * @author schema.org
 * @class CivicStructure
 * @module org.schema
 * @extends Place
 */
public class CivicStructure extends Place {
	/**
	 * Schema.org/openingHours
	 * The general opening hours for a business. Opening hours can be specified as a weekly time range, starting with days, then times per day. Multiple days can be listed with commas ',' separating each day. Day or time ranges are specified using a hyphen '-'.\n\n* Days are specified using the following two-letter combinations: ```Mo```, ```Tu```, ```We```, ```Th```, ```Fr```, ```Sa```, ```Su```.\n* Times are specified using 24:00 time. For example, 3pm is specified as ```15:00```. \n* Here is an example: <code>&lt;time itemprop="openingHours" datetime=&quot;Tu,Th 16:00-20:00&quot;&gt;Tuesdays and Thursdays 4-8pm&lt;/time&gt;</code>.\n* If a business is open 7 days a week, then it can be specified as <code>&lt;time itemprop=&quot;openingHours&quot; datetime=&quot;Mo-Su&quot;&gt;Monday through Sunday, all day&lt;/time&gt;</code>.
	 *
	 * @property openingHours
	 * @type Text
	 */
	public String openingHours;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CivicStructure() {
		context = "http://schema.org/";
		type = "CivicStructure";
	}

}