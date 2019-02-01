package org.schema;

/**
 * Schema.org/NutritionInformation
 * Nutritional information about the recipe.
 *
 * @author schema.org
 * @class NutritionInformation
 * @module org.schema
 * @extends StructuredValue
 */
public class NutritionInformation extends StructuredValue {
	/**
	 * Schema.org/saturatedFatContent
	 * The number of grams of saturated fat.
	 *
	 * @property saturatedFatContent
	 * @type Mass
	 */
	public Mass saturatedFatContent;
	/**
	 * Schema.org/fatContent
	 * The number of grams of fat.
	 *
	 * @property fatContent
	 * @type Mass
	 */
	public Mass fatContent;
	/**
	 * Schema.org/unsaturatedFatContent
	 * The number of grams of unsaturated fat.
	 *
	 * @property unsaturatedFatContent
	 * @type Mass
	 */
	public Mass unsaturatedFatContent;
	/**
	 * Schema.org/sugarContent
	 * The number of grams of sugar.
	 *
	 * @property sugarContent
	 * @type Mass
	 */
	public Mass sugarContent;
	/**
	 * Schema.org/cholesterolContent
	 * The number of milligrams of cholesterol.
	 *
	 * @property cholesterolContent
	 * @type Mass
	 */
	public Mass cholesterolContent;
	/**
	 * Schema.org/carbohydrateContent
	 * The number of grams of carbohydrates.
	 *
	 * @property carbohydrateContent
	 * @type Mass
	 */
	public Mass carbohydrateContent;
	/**
	 * Schema.org/proteinContent
	 * The number of grams of protein.
	 *
	 * @property proteinContent
	 * @type Mass
	 */
	public Mass proteinContent;
	/**
	 * Schema.org/sodiumContent
	 * The number of milligrams of sodium.
	 *
	 * @property sodiumContent
	 * @type Mass
	 */
	public Mass sodiumContent;
	/**
	 * Schema.org/transFatContent
	 * The number of grams of trans fat.
	 *
	 * @property transFatContent
	 * @type Mass
	 */
	public Mass transFatContent;
	/**
	 * Schema.org/fiberContent
	 * The number of grams of fiber.
	 *
	 * @property fiberContent
	 * @type Mass
	 */
	public Mass fiberContent;
	/**
	 * Schema.org/calories
	 * The number of calories.
	 *
	 * @property calories
	 * @type Energy
	 */
	public Energy calories;
	/**
	 * Schema.org/servingSize
	 * The serving size, in terms of the number of volume or mass.
	 *
	 * @property servingSize
	 * @type Text
	 */
	public String servingSize;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public NutritionInformation() {
		context = "http://schema.org/";
		type = "NutritionInformation";
	}

}