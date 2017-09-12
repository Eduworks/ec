package org.schema;

/**
 * Schema.org/FoodService
 * A food service, like breakfast, lunch, or dinner.
 *
 * @author schema.org
 * @class FoodService
 * @module org.schema
 * @extends Service
 */
public class FoodService extends Service {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FoodService() {
		context = "http://schema.org/";
		type = "FoodService";
	}

}