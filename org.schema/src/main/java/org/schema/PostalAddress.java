package org.schema;

/**
 * Schema.org/PostalAddress
 * The mailing address.
 *
 * @author schema.org
 * @class PostalAddress
 * @module org.schema
 * @extends ContactPoint
 */
public class PostalAddress extends ContactPoint {
	/**
	 * Schema.org/postOfficeBoxNumber
	 * The post office box number for PO box addresses.
	 *
	 * @property postOfficeBoxNumber
	 * @type Text
	 */
	public String postOfficeBoxNumber;
	/**
	 * Schema.org/streetAddress
	 * The street address. For example, 1600 Amphitheatre Pkwy.
	 *
	 * @property streetAddress
	 * @type Text
	 */
	public String streetAddress;
	/**
	 * Schema.org/addressCountry
	 * The country. For example, USA. You can also provide the two-letter [ISO 3166-1 alpha-2 country code](http://en.wikipedia.org/wiki/ISO_3166-1).
	 *
	 * @property addressCountry
	 * @type Text
	 */
	public String addressCountry;
	/**
	 * Schema.org/addressRegion
	 * The region. For example, CA.
	 *
	 * @property addressRegion
	 * @type Text
	 */
	public String addressRegion;
	/**
	 * Schema.org/postalCode
	 * The postal code. For example, 94043.
	 *
	 * @property postalCode
	 * @type Text
	 */
	public String postalCode;
	/**
	 * Schema.org/addressLocality
	 * The locality. For example, Mountain View.
	 *
	 * @property addressLocality
	 * @type Text
	 */
	public String addressLocality;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PostalAddress() {
		context = "http://schema.org/";
		type = "PostalAddress";
	}

}