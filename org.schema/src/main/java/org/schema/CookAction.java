package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CookAction
 * The act of producing/preparing food.
 * @author schema.org
 * @module schema.org
 * @class CookAction
 * @extends CreateAction
 */
public class CookAction extends CreateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CookAction()
	{
		context="http://schema.org/";
		type="CookAction";
	}

	/**
	 * Schema.org/foodEstablishment
	 * A sub property of location. The specific food establishment where the action occurred.
	 * @property foodEstablishment
	 * @type schema,FoodEstablishment | schema,Place	 */
	public Object foodEstablishment;

	/**
	 * Schema.org/recipe
	 * A sub property of instrument. The recipe/instructions used to perform the action.
	 * @property recipe
	 * @type Recipe
	 */
	public Recipe recipe;

	/**
	 * Schema.org/foodEvent
	 * A sub property of location. The specific food event where the action occurred.
	 * @property foodEvent
	 * @type FoodEvent
	 */
	public FoodEvent foodEvent;

}