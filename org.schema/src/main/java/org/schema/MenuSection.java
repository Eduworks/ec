package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MenuSection
 * A sub-grouping of food or drink items in a menu. E.g. courses (such as 'Dinner', 'Breakfast', etc.), specific type of dishes (such as 'Meat', 'Vegan', 'Drinks', etc.), or some other classification made by the menu provider.
 * @author schema.org
 * @class MenuSection
 * @module org.schema
 * @extends CreativeWork
 */
public class MenuSection extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MenuSection()
	{
		context="http://schema.org/";
		type="MenuSection";
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