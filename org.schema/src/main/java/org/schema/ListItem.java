package org.schema;

/**
 * Schema.org/ListItem
 * An list item, e.g. a step in a checklist or how-to description.
 * @author schema.org
 * @class ListItem
 * @module org.schema
 * @extends Intangible
 */
public class ListItem extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ListItem()
	{
		context="http://schema.org/";
		type="ListItem";
	}

	/**
	 * Schema.org/position
	 * The position of an item in a series or sequence of items.
	 * @property position
	 * @type schema,Integer | schema,Text
	 */
	public Object position;

	/**
	 * Schema.org/previousItem
	 * A link to the ListItem that preceeds the current one.
	 * @property previousItem
	 * @type ListItem
	 */
	public ListItem previousItem;

	/**
	 * Schema.org/nextItem
	 * A link to the ListItem that follows the current one.
	 * @property nextItem
	 * @type ListItem
	 */
	public ListItem nextItem;

	/**
	 * Schema.org/item
	 * An entity represented by an entry in a list or data feed (e.g. an 'artist' in a list of 'artists')’.
	 * @property item
	 * @type Thing
	 */
	public Thing item;

}