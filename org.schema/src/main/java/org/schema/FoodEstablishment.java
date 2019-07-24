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
	 * @type URL
	 */
	public String hasMenu;
	/**
	 * Schema.org/menu
	 * Either the actual menu as a structured representation, as text, or a URL of the menu.
	 *
	 * @property menu
	 * @type Menu
	 */
	public Menu menu;
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
	 * @type URL
	 */
	public String acceptsReservations;

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