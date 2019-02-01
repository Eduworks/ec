package org.schema;

/**
 * Schema.org/Rating
 * A rating is an evaluation on a numeric scale, such as 1 to 5 stars.
 *
 * @author schema.org
 * @class Rating
 * @module org.schema
 * @extends Intangible
 */
public class Rating extends Intangible {
	/**
	 * Schema.org/ratingValue
	 * The rating for the content.
	 *
	 * @property ratingValue
	 * @type Number
	 */
	public Double ratingValue;
	/**
	 * Schema.org/bestRating
	 * The highest value allowed in this rating system. If bestRating is omitted, 5 is assumed.
	 *
	 * @property bestRating
	 * @type Number
	 */
	public Double bestRating;
	/**
	 * Schema.org/author
	 * The author of this content or rating. Please note that author is special in that HTML 5 provides a special mechanism for indicating authorship via the rel tag. That is equivalent to this and may be used interchangeably.
	 *
	 * @property author
	 * @type Person
	 */
	public Person author;
	/**
	 * Schema.org/worstRating
	 * The lowest value allowed in this rating system. If worstRating is omitted, 1 is assumed.
	 *
	 * @property worstRating
	 * @type Text
	 */
	public String worstRating;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Rating() {
		context = "http://schema.org/";
		type = "Rating";
	}

}