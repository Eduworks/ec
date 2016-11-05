package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/FoodEstablishment
 * A food-related business.
 * @author schema.org
 * @module schema.org
 * @class FoodEstablishment
 * @extends LocalBusiness
 */
public class FoodEstablishment extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FoodEstablishment()
	{
		context="http://schema.org/";
		type="FoodEstablishment";
	}

	/**
	 * Schema.org/starRating
	 * An official rating for a lodging business or food establishment, e.g. from national associations or standards bodies. Use the author property to indicate the rating organization, e.g. as an Organization with name such as (e.g. HOTREC, DEHOGA, WHR, or Hotelstars).
	 * @property starRating
	 * @type Rating
	 */
	public Rating starRating;

	/**
	 * Schema.org/acceptsReservations
	 * Indicates whether a FoodEstablishment accepts reservations. Values can be Boolean, an URL at which reservations can be made or (for backwards compatibility) the strings ```Yes``` or ```No```.
	 * @property acceptsReservations
	 * @type schema,Text | schema,Boolean | schema,URL	 */
	public Object acceptsReservations;

	/**
	 * Schema.org/servesCuisine
	 * The cuisine of the restaurant.
	 * @property servesCuisine
	 * @type Text
	 */
	public String servesCuisine;

	/**
	 * Schema.org/menu
	 * Either the actual menu or a URL of the menu.
	 * @property menu
	 * @type schema,Text | schema,URL	 */
	public Object menu;

}