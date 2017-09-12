package org.schema;

/**
 * Schema.org/FoodEstablishment
 * A food-related business.
 *
 * @author schema.org
 * @class FoodEstablishment
 * @module org.schema
 * @extends LocalBusiness
 */
public class FoodEstablishment extends LocalBusiness {
	/**
	 * Schema.org/starRating
	 * An official rating for a lodging business or food establishment, e.g. from national associations or standards bodies. Use the author property to indicate the rating organization, e.g. as an Organization with name such as (e.g. HOTREC, DEHOGA, WHR, or Hotelstars).
	 *
	 * @property starRating
	 * @type Rating
	 */
	public Rating starRating;
	/**
	 * Schema.org/acceptsReservations
	 * Indicates whether a FoodEstablishment accepts reservations. Values can be Boolean, an URL at which reservations can be made or (for backwards compatibility) the strings ```Yes``` or ```No```.
	 *
	 * @property acceptsReservations
	 * @type schema, URL | schema,Boolean | schema,Text
	 */
	public Object acceptsReservations;
	/**
	 * Schema.org/menu
	 * Either the actual menu as a structured representation, as text, or a URL of the menu.
	 *
	 * @property menu
	 * @type schema, URL | schema,Text | schema,Menu
	 */
	public Object menu;
	/**
	 * Schema.org/servesCuisine
	 * The cuisine of the restaurant.
	 *
	 * @property servesCuisine
	 * @type Text
	 */
	public String servesCuisine;
	/**
	 * Schema.org/hasMenu
	 * Either the actual menu as a structured representation, as text, or a URL of the menu.
	 *
	 * @property hasMenu
	 * @type schema, URL | schema,Text | schema,Menu
	 */
	public Object hasMenu;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FoodEstablishment() {
		context = "http://schema.org/";
		type = "FoodEstablishment";
	}

}