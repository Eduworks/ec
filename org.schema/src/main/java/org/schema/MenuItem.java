package org.schema;

/**
 * Schema.org/MenuItem
 * A food or drink item listed in a menu or menu section.
 *
 * @author schema.org
 * @class MenuItem
 * @module org.schema
 * @extends Intangible
 */
public class MenuItem extends Intangible {
	/**
	 * Schema.org/suitableForDiet
	 * Indicates a dietary restriction or guideline for which this recipe or menu item is suitable, e.g. diabetic, halal etc.
	 *
	 * @property suitableForDiet
	 * @type RestrictedDiet
	 */
	public RestrictedDiet suitableForDiet;
	/**
	 * Schema.org/offers
	 * An offer to provide this item&#x2014;for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event.
	 *
	 * @property offers
	 * @type Offer
	 */
	public Offer offers;
	/**
	 * Schema.org/nutrition
	 * Nutrition information about the recipe or menu item.
	 *
	 * @property nutrition
	 * @type NutritionInformation
	 */
	public NutritionInformation nutrition;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MenuItem() {
		context = "http://schema.org/";
		type = "MenuItem";
	}

}