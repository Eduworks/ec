package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GeoCoordinates
 * The geographic coordinates of a place or event.
 * @author schema.org
 * @class GeoCoordinates
 * @module org.schema
 * @extends StructuredValue
 */
public class GeoCoordinates extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GeoCoordinates()
	{
		context="http://schema.org/";
		type="GeoCoordinates";
	}

	/**
	 * Schema.org/postalCode
	 * The postal code. For example, 94043.
	 * @property postalCode
	 * @type Text
	 */
	public String postalCode;

	/**
	 * Schema.org/latitude
	 * The latitude of a location. For example ```37.42242``` ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 * @property latitude
	 * @type schema,Number | schema,Text
	 */
	public Object latitude;

	/**
	 * Schema.org/elevation
	 * The elevation of a location ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 * @property elevation
	 * @type schema,Number | schema,Text
	 */
	public Object elevation;

	/**
	 * Schema.org/longitude
	 * The longitude of a location. For example ```-122.08585``` ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 * @property longitude
	 * @type schema,Number | schema,Text
	 */
	public Object longitude;

	/**
	 * Schema.org/addressCountry
	 * The country. For example, USA. You can also provide the two-letter [ISO 3166-1 alpha-2 country code](http://en.wikipedia.org/wiki/ISO_3166-1).
	 * @property addressCountry
	 * @type schema,Text | schema,Country
	 */
	public Object addressCountry;

	/**
	 * Schema.org/address
	 * Physical address of the item.
	 * @property address
	 * @type schema,PostalAddress | schema,Text
	 */
	public Object address;

}