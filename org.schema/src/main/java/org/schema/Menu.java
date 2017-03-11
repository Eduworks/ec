package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Menu
 * A structured representation of food or drink items available from a FoodEstablishment.
 * @author schema.org
 * @class Menu
 * @module org.schema
 * @extends CreativeWork
 */
public class Menu extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Menu()
	{
		context="http://schema.org/";
		type="Menu";
	}

	/**
	 * Schema.org/hasMenuSection
	 * A subgrouping of the menu (by dishes, course, serving time period, etc.).
	 * @property hasMenuSection
	 * @type MenuSection
	 */
	public MenuSection hasMenuSection;

	/**
	 * Schema.org/hasMenuItem
	 * A food or drink item contained in a menu or menu section.
	 * @property hasMenuItem
	 * @type MenuItem
	 */
	public MenuItem hasMenuItem;

}