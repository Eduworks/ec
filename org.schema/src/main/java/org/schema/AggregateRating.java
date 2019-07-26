package org.schema;

/**
 * Schema.org/AggregateRating
 * The average rating based on multiple ratings or reviews.
 *
 * @author schema.org
 * @class AggregateRating
 * @module org.schema
 * @extends Rating
 */
public class AggregateRating extends Rating {
	/**
	 * Schema.org/itemReviewed
	 * The item that is being reviewed/rated.
	 *
	 * @property itemReviewed
	 * @type Thing
	 */
	public Thing itemReviewed;
	/**
	 * Schema.org/reviewCount
	 * The count of total number of reviews.
	 *
	 * @property reviewCount
	 * @type Integer
	 */
	public Integer reviewCount;
	/**
	 * Schema.org/ratingCount
	 * The count of total number of ratings.
	 *
	 * @property ratingCount
	 * @type Integer
	 */
	public Integer ratingCount;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AggregateRating() {
		context = "http://schema.org/";
		type = "AggregateRating";
	}

}