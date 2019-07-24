package org.schema;

/**
 * Schema.org/OfferCatalog
 * An OfferCatalog is an ItemList that contains related Offers and/or further OfferCatalogs that are offeredBy the same provider.
 *
 * @author schema.org
 * @class OfferCatalog
 * @module org.schema
 * @extends ItemList
 */
public class OfferCatalog extends ItemList {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OfferCatalog() {
		context = "http://schema.org/";
		type = "OfferCatalog";
	}

}