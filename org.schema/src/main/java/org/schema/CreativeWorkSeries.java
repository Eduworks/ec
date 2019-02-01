package org.schema;

/**
 * Schema.org/CreativeWorkSeries
 * A CreativeWorkSeries in schema.org is a group of related items, typically but not necessarily of the same kind. CreativeWorkSeries are usually organized into some order, often chronological. Unlike [[ItemList]] which is a general purpose data structure for lists of things, the emphasis with CreativeWorkSeries is on published materials (written e.g. books and periodicals, or media such as tv, radio and games).\n\nSpecific subtypes are available for describing [[TVSeries]], [[RadioSeries]], [[MovieSeries]], [[BookSeries]], [[Periodical]] and [[VideoGameSeries]]. In each case, the [[hasPart]] / [[isPartOf]] properties can be used to relate the CreativeWorkSeries to its parts. The general CreativeWorkSeries type serves largely just to organize these more specific and practical subtypes.\n\nIt is common for properties applicable to an item from the series to be usefully applied to the containing group. Schema.org attempts to anticipate some of these cases, but publishers should be free to apply properties of the series parts to the series as a whole wherever they seem appropriate.
 *
 * @author schema.org
 * @class CreativeWorkSeries
 * @module org.schema
 * @extends CreativeWork
 */
public class CreativeWorkSeries extends CreativeWork {
	/**
	 * Schema.org/endDate
	 * The end date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 *
	 * @property endDate
	 * @type DateTime
	 */
	public String endDate;
	/**
	 * Schema.org/startDate
	 * The start date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 *
	 * @property startDate
	 * @type Date
	 */
	public String startDate;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CreativeWorkSeries() {
		context = "http://schema.org/";
		type = "CreativeWorkSeries";
	}

}