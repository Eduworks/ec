package org.schema;

/**
 * Schema.org/ClaimReview
 * A fact-checking review of claims made (or reported) in some creative work (referenced via itemReviewed).
 *
 * @author schema.org
 * @class ClaimReview
 * @module org.schema
 * @extends Review
 */
public class ClaimReview extends Review {
	/**
	 * Schema.org/claimReviewed
	 * A short summary of the specific claims reviewed in a ClaimReview.
	 *
	 * @property claimReviewed
	 * @type Text
	 */
	public String claimReviewed;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ClaimReview() {
		context = "http://schema.org/";
		type = "ClaimReview";
	}

}