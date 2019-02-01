package org.schema;

/**
 * Schema.org/Brand
 * A brand is a name used by an organization or business person for labeling a product, product group, or similar.
 *
 * @author schema.org
 * @class Brand
 * @module org.schema
 * @extends Intangible
 */
public class Brand extends Intangible {
	/**
	 * Schema.org/aggregateRating
	 * The overall rating, based on a collection of reviews or ratings, of the item.
	 *
	 * @property aggregateRating
	 * @type AggregateRating
	 */
	public AggregateRating aggregateRating;
	/**
	 * Schema.org/logo
	 * An associated logo.
	 *
	 * @property logo
	 * @type ImageObject
	 */
	public ImageObject logo;
	/**
	 * Schema.org/review
	 * A review of the item.
	 *
	 * @property review
	 * @type Review
	 */
	public Review review;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Brand() {
		context = "http://schema.org/";
		type = "Brand";
	}

}