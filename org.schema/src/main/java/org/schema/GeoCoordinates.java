package org.schema;

/**
 * Schema.org/GeoCoordinates
 * The geographic coordinates of a place or event.
 *
 * @author schema.org
 * @class GeoCoordinates
 * @module org.schema
 * @extends StructuredValue
 */
public class GeoCoordinates extends StructuredValue {
	/**
	 * Schema.org/address
	 * Physical address of the item.
	 *
	 * @property address
	 * @type PostalAddress
	 */
	public PostalAddress address;
	/**
	 * Schema.org/latitude
	 * The latitude of a location. For example ```37.42242``` ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 *
	 * @property latitude
	 * @type Text
	 */
	public String latitude;
	/**
	 * Schema.org/longitude
	 * The longitude of a location. For example ```-122.08585``` ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 *
	 * @property longitude
	 * @type Text
	 */
	public String longitude;
	/**
	 * Schema.org/addressCountry
	 * The country. For example, USA. You can also provide the two-letter [ISO 3166-1 alpha-2 country code](http://en.wikipedia.org/wiki/ISO_3166-1).
	 *
	 * @property addressCountry
	 * @type Text
	 */
	public String addressCountry;
	/**
	 * Schema.org/postalCode
	 * The postal code. For example, 94043.
	 *
	 * @property postalCode
	 * @type Text
	 */
	public String postalCode;
	/**
	 * Schema.org/elevation
	 * The elevation of a location ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 *
	 * @property elevation
	 * @type Text
	 */
	public String elevation;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GeoCoordinates() {
		context = "http://schema.org/";
		type = "GeoCoordinates";
	}

}