package org.schema;

/**
 * Schema.org/GeoShape
 * The geographic shape of a place. A GeoShape can be described using several properties whose values are based on latitude/longitude pairs. Either whitespace or commas can be used to separate latitude and longitude; whitespace should be used when writing a list of several such points.
 * @author schema.org
 * @class GeoShape
 * @module org.schema
 * @extends StructuredValue
 */
public class GeoShape extends StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GeoShape()
	{
		context="http://schema.org/";
		type="GeoShape";
	}

	/**
	 * Schema.org/postalCode
	 * The postal code. For example, 94043.
	 * @property postalCode
	 * @type Text
	 */
	public String postalCode;

	/**
	 * Schema.org/elevation
	 * The elevation of a location ([WGS 84](https://en.wikipedia.org/wiki/World_Geodetic_System)).
	 * @property elevation
	 * @type schema,Number | schema,Text
	 */
	public Object elevation;

	/**
	 * Schema.org/line
	 * A line is a point-to-point path consisting of two or more points. A line is expressed as a series of two or more point objects separated by space.
	 * @property line
	 * @type Text
	 */
	public String line;

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

	/**
	 * Schema.org/polygon
	 * A polygon is the area enclosed by a point-to-point path for which the starting and ending points are the same. A polygon is expressed as a series of four or more space delimited points where the first and final points are identical.
	 * @property polygon
	 * @type Text
	 */
	public String polygon;

	/**
	 * Schema.org/box
	 * A box is the area enclosed by the rectangle formed by two points. The first point is the lower corner, the second point is the upper corner. A box is expressed as two points separated by a space character.
	 * @property box
	 * @type Text
	 */
	public String box;

	/**
	 * Schema.org/circle
	 * A circle is the circular region of a specified radius centered at a specified latitude and longitude. A circle is expressed as a pair followed by a radius in meters.
	 * @property circle
	 * @type Text
	 */
	public String circle;

}