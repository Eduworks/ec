package org.schema;

/**
 * Schema.org/Review
 * A review of an item - for example, of a restaurant, movie, or store.
 *
 * @author schema.org
 * @class Review
 * @module org.schema
 * @extends CreativeWork
 */
public class Review extends CreativeWork {
	/**
	 * Schema.org/reviewRating
	 * The rating given in this review. Note that reviews can themselves be rated. The ```reviewRating``` applies to rating given by the review. The [[aggregateRating]] property applies to the review itself, as a creative work.
	 *
	 * @property reviewRating
	 * @type Rating
	 */
	public Rating reviewRating;
	/**
	 * Schema.org/itemReviewed
	 * The item that is being reviewed/rated.
	 *
	 * @property itemReviewed
	 * @type Thing
	 */
	public Thing itemReviewed;
	/**
	 * Schema.org/reviewBody
	 * The actual body of the review.
	 *
	 * @property reviewBody
	 * @type Text
	 */
	public String reviewBody;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Review() {
		context = "http://schema.org/";
		type = "Review";
	}

}