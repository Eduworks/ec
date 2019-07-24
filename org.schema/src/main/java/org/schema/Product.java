package org.schema;

/**
 * Schema.org/Product
 * Any offered product or service. For example: a pair of shoes; a concert ticket; the rental of a car; a haircut; or an episode of a TV show streamed online.
 *
 * @author schema.org
 * @class Product
 * @module org.schema
 * @extends Thing
 */
public class Product extends Thing {
	/**
	 * Schema.org/manufacturer
	 * The manufacturer of the product.
	 *
	 * @property manufacturer
	 * @type Organization
	 */
	public Organization manufacturer;
	/**
	 * Schema.org/sku
	 * The Stock Keeping Unit (SKU), i.e. a merchant-specific identifier for a product or service, or the product to which the offer refers.
	 *
	 * @property sku
	 * @type Text
	 */
	public String sku;
	/**
	 * Schema.org/productionDate
	 * The date of production of the item, e.g. vehicle.
	 *
	 * @property productionDate
	 * @type Date
	 */
	public String productionDate;
	/**
	 * Schema.org/audience
	 * An intended audience, i.e. a group for whom something was created.
	 *
	 * @property audience
	 * @type Audience
	 */
	public Audience audience;
	/**
	 * Schema.org/mpn
	 * The Manufacturer Part Number (MPN) of the product, or the product to which the offer refers.
	 *
	 * @property mpn
	 * @type Text
	 */
	public String mpn;
	/**
	 * Schema.org/height
	 * The height of the item.
	 *
	 * @property height
	 * @type Distance
	 */
	public Distance height;
	/**
	 * Schema.org/gtin8
	 * The [GTIN-8](http://apps.gs1.org/GDD/glossary/Pages/GTIN-8.aspx) code of the product, or the product to which the offer refers. This code is also known as EAN/UCC-8 or 8-digit EAN. See [GS1 GTIN Summary](http://www.gs1.org/barcodes/technical/idkeys/gtin) for more details.
	 *
	 * @property gtin8
	 * @type Text
	 */
	public String gtin8;
	/**
	 * Schema.org/reviews
	 * Review of the item.
	 *
	 * @property reviews
	 * @type Review
	 */
	public Review reviews;
	/**
	 * Schema.org/aggregateRating
	 * The overall rating, based on a collection of reviews or ratings, of the item.
	 *
	 * @property aggregateRating
	 * @type AggregateRating
	 */
	public AggregateRating aggregateRating;
	/**
	 * Schema.org/isConsumableFor
	 * A pointer to another product (or multiple products) for which this product is a consumable.
	 *
	 * @property isConsumableFor
	 * @type Product
	 */
	public Product isConsumableFor;
	/**
	 * Schema.org/offers
	 * An offer to provide this item&#x2014;for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event.
	 *
	 * @property offers
	 * @type Offer
	 */
	public Offer offers;
	/**
	 * Schema.org/award
	 * An award won by or for this item.
	 *
	 * @property award
	 * @type Text
	 */
	public String award;
	/**
	 * Schema.org/category
	 * A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
	 *
	 * @property category
	 * @type Text
	 */
	public String category;
	/**
	 * Schema.org/width
	 * The width of the item.
	 *
	 * @property width
	 * @type Distance
	 */
	public Distance width;
	/**
	 * Schema.org/awards
	 * Awards won by or for this item.
	 *
	 * @property awards
	 * @type Text
	 */
	public String awards;
	/**
	 * Schema.org/additionalProperty
	 * A property-value pair representing an additional characteristics of the entitity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.\n\nNote: Publishers should be aware that applications designed to use specific schema.org properties (e.g. schema:width, schema:color, schema:gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.
	 *
	 * @property additionalProperty
	 * @type PropertyValue
	 */
	public PropertyValue additionalProperty;
	/**
	 * Schema.org/isAccessoryOrSparePartFor
	 * A pointer to another product (or multiple products) for which this product is an accessory or spare part.
	 *
	 * @property isAccessoryOrSparePartFor
	 * @type Product
	 */
	public Product isAccessoryOrSparePartFor;
	/**
	 * Schema.org/logo
	 * An associated logo.
	 *
	 * @property logo
	 * @type ImageObject
	 */
	public ImageObject logo;
	/**
	 * Schema.org/gtin14
	 * The [GTIN-14](http://apps.gs1.org/GDD/glossary/Pages/GTIN-14.aspx) code of the product, or the product to which the offer refers. See [GS1 GTIN Summary](http://www.gs1.org/barcodes/technical/idkeys/gtin) for more details.
	 *
	 * @property gtin14
	 * @type Text
	 */
	public String gtin14;
	/**
	 * Schema.org/gtin13
	 * The [GTIN-13](http://apps.gs1.org/GDD/glossary/Pages/GTIN-13.aspx) code of the product, or the product to which the offer refers. This is equivalent to 13-digit ISBN codes and EAN UCC-13. Former 12-digit UPC codes can be converted into a GTIN-13 code by simply adding a preceeding zero. See [GS1 GTIN Summary](http://www.gs1.org/barcodes/technical/idkeys/gtin) for more details.
	 *
	 * @property gtin13
	 * @type Text
	 */
	public String gtin13;
	/**
	 * Schema.org/gtin12
	 * The [GTIN-12](http://apps.gs1.org/GDD/glossary/Pages/GTIN-12.aspx) code of the product, or the product to which the offer refers. The GTIN-12 is the 12-digit GS1 Identification Key composed of a U.P.C. Company Prefix, Item Reference, and Check Digit used to identify trade items. See [GS1 GTIN Summary](http://www.gs1.org/barcodes/technical/idkeys/gtin) for more details.
	 *
	 * @property gtin12
	 * @type Text
	 */
	public String gtin12;
	/**
	 * Schema.org/material
	 * A material that something is made from, e.g. leather, wool, cotton, paper.
	 *
	 * @property material
	 * @type URL
	 */
	public String material;
	/**
	 * Schema.org/weight
	 * The weight of the product or person.
	 *
	 * @property weight
	 * @type QuantitativeValue
	 */
	public QuantitativeValue weight;
	/**
	 * Schema.org/depth
	 * The depth of the item.
	 *
	 * @property depth
	 * @type Distance
	 */
	public Distance depth;
	/**
	 * Schema.org/isSimilarTo
	 * A pointer to another, functionally similar product (or multiple products).
	 *
	 * @property isSimilarTo
	 * @type Product
	 */
	public Product isSimilarTo;
	/**
	 * Schema.org/model
	 * The model of the product. Use with the URL of a ProductModel or a textual representation of the model identifier. The URL of the ProductModel can be from an external source. It is recommended to additionally provide strong product identifiers via the gtin8/gtin13/gtin14 and mpn properties.
	 *
	 * @property model
	 * @type Text
	 */
	public String model;
	/**
	 * Schema.org/color
	 * The color of the product.
	 *
	 * @property color
	 * @type Text
	 */
	public String color;
	/**
	 * Schema.org/isRelatedTo
	 * A pointer to another, somehow related product (or multiple products).
	 *
	 * @property isRelatedTo
	 * @type Product
	 */
	public Product isRelatedTo;
	/**
	 * Schema.org/productID
	 * The product identifier, such as ISBN. For example: ``` meta itemprop="productID" content="isbn:123-456-789" ```.
	 *
	 * @property productID
	 * @type Text
	 */
	public String productID;
	/**
	 * Schema.org/review
	 * A review of the item.
	 *
	 * @property review
	 * @type Review
	 */
	public Review review;
	/**
	 * Schema.org/purchaseDate
	 * The date the item e.g. vehicle was purchased by the current owner.
	 *
	 * @property purchaseDate
	 * @type Date
	 */
	public String purchaseDate;
	/**
	 * Schema.org/itemCondition
	 * A predefined value from OfferItemCondition or a textual description of the condition of the product or service, or the products or services included in the offer.
	 *
	 * @property itemCondition
	 * @type OfferItemCondition
	 */
	public OfferItemCondition itemCondition;
	/**
	 * Schema.org/brand
	 * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
	 *
	 * @property brand
	 * @type Organization
	 */
	public Organization brand;
	/**
	 * Schema.org/releaseDate
	 * The release date of a product or product model. This can be used to distinguish the exact variant of a product.
	 *
	 * @property releaseDate
	 * @type Date
	 */
	public String releaseDate;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Product() {
		context = "http://schema.org/";
		type = "Product";
	}

}