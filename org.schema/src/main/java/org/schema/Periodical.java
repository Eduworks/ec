package org.schema;

/**
 * Schema.org/Periodical
 * A publication in any medium issued in successive parts bearing numerical or chronological designations and intended, such as a magazine, scholarly journal, or newspaper to continue indefinitely.\n\nSee also [blog post](http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html).
 *
 * @author schema.org
 * @class Periodical
 * @module org.schema
 * @extends CreativeWorkSeries
 */
public class Periodical extends CreativeWorkSeries {
	/**
	 * Schema.org/issn
	 * The International Standard Serial Number (ISSN) that identifies this periodical. You can repeat this property to (for example) identify different formats of this periodical.
	 *
	 * @property issn
	 * @type Text
	 */
	public String issn;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Periodical() {
		context = "http://schema.org/";
		type = "Periodical";
	}

}