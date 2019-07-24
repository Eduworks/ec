package org.schema;

/**
 * Schema.org/PublicationVolume
 * A part of a successively published publication such as a periodical or multi-volume work, often numbered. It may represent a time span, such as a year.
 * <p>
 * <br/><br/>See also <a href="http://blog.schema.org/2014/09/schemaorg-support-for-bibliographic_2.html">blog post</a>.
 *
 * @author schema.org
 * @class PublicationVolume
 * @module org.schema
 * @extends CreativeWork
 */
public class PublicationVolume extends CreativeWork {
	/**
	 * Schema.org/pagination
	 * Any description of pages that is not separated into pageStart and pageEnd; for example, "1-6, 9, 55" or "10-12, 46-49".
	 *
	 * @property pagination
	 * @type Text
	 */
	public String pagination;
	/**
	 * Schema.org/pageEnd
	 * The page on which the work ends; for example "138" or "xvi".
	 *
	 * @property pageEnd
	 * @type Integer
	 */
	public Integer pageEnd;
	/**
	 * Schema.org/volumeNumber
	 * Identifies the volume of publication or multi-part work; for example, "iii" or "2".
	 *
	 * @property volumeNumber
	 * @type Integer
	 */
	public Integer volumeNumber;
	/**
	 * Schema.org/pageStart
	 * The page on which the work starts; for example "135" or "xiii".
	 *
	 * @property pageStart
	 * @type Integer
	 */
	public Integer pageStart;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PublicationVolume() {
		context = "http://schema.org/";
		type = "PublicationVolume";
	}

}