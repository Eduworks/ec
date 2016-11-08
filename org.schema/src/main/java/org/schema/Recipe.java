package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Recipe
 * A recipe. For dietary restrictions covered by the recipe, a few common restrictions are enumerated via [[suitableForDiet]]. The [[keywords]] property can also be used to add more detail.
 * @author schema.org
 * @class Recipe
 * @module org.schema
 * @extends CreativeWork
 */
public class Recipe extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Recipe()
	{
		context="http://schema.org/";
		type="Recipe";
	}

	/**
	 * Schema.org/recipeYield
	 * The quantity produced by the recipe (for example, number of people served, number of servings, etc).
	 * @property recipeYield
	 * @type Text
	 */
	public String recipeYield;

	/**
	 * Schema.org/cookingMethod
	 * The method of cooking, such as Frying, Steaming, ...
	 * @property cookingMethod
	 * @type Text
	 */
	public String cookingMethod;

	/**
	 * Schema.org/recipeCuisine
	 * The cuisine of the recipe (for example, French or Ethiopian).
	 * @property recipeCuisine
	 * @type Text
	 */
	public String recipeCuisine;

	/**
	 * Schema.org/suitableForDiet
	 * Indicates a dietary restriction or guideline for which this recipe is suitable, e.g. diabetic, halal etc.
	 * @property suitableForDiet
	 * @type RestrictedDiet
	 */
	public RestrictedDiet suitableForDiet;

	/**
	 * Schema.org/recipeInstructions
	 * A step or instruction involved in making the recipe.
	 * @property recipeInstructions
	 * @type schema,ItemList | schema,Text
	 */
	public Object recipeInstructions;

	/**
	 * Schema.org/cookTime
	 * The time it takes to actually cook the dish, in [ISO 8601 duration format](http://en.wikipedia.org/wiki/ISO_8601).
	 * @property cookTime
	 * @type Duration
	 */
	public Duration cookTime;

	/**
	 * Schema.org/prepTime
	 * The length of time it takes to prepare the recipe, in [ISO 8601 duration format](http://en.wikipedia.org/wiki/ISO_8601).
	 * @property prepTime
	 * @type Duration
	 */
	public Duration prepTime;

	/**
	 * Schema.org/totalTime
	 * The total time it takes to prepare and cook the recipe, in [ISO 8601 duration format](http://en.wikipedia.org/wiki/ISO_8601).
	 * @property totalTime
	 * @type Duration
	 */
	public Duration totalTime;

	/**
	 * Schema.org/nutrition
	 * Nutrition information about the recipe.
	 * @property nutrition
	 * @type NutritionInformation
	 */
	public NutritionInformation nutrition;

	/**
	 * Schema.org/recipeCategory
	 * The category of the recipe—for example, appetizer, entree, etc.
	 * @property recipeCategory
	 * @type Text
	 */
	public String recipeCategory;

	/**
	 * Schema.org/recipeIngredient
	 * A single ingredient used in the recipe, e.g. sugar, flour or garlic.
	 * @property recipeIngredient
	 * @type Text
	 */
	public String recipeIngredient;

	/**
	 * Schema.org/ingredients
	 * A single ingredient used in the recipe, e.g. sugar, flour or garlic.
	 * @property ingredients
	 * @type Text
	 */
	public String ingredients;

}