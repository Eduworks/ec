package org.schema;

/**
 * Schema.org/PeopleAudience
 * A set of characteristics belonging to people, e.g. who compose an item's target audience.
 *
 * @author schema.org
 * @class PeopleAudience
 * @module org.schema
 * @extends Audience
 */
public class PeopleAudience extends Audience {
	/**
	 * Schema.org/suggestedMaxAge
	 * Maximal age recommended for viewing content.
	 *
	 * @property suggestedMaxAge
	 * @type Number
	 */
	public Double suggestedMaxAge;
	/**
	 * Schema.org/requiredMinAge
	 * Audiences defined by a person's minimum age.
	 *
	 * @property requiredMinAge
	 * @type Integer
	 */
	public Integer requiredMinAge;
	/**
	 * Schema.org/requiredGender
	 * Audiences defined by a person's gender.
	 *
	 * @property requiredGender
	 * @type Text
	 */
	public String requiredGender;
	/**
	 * Schema.org/suggestedGender
	 * The gender of the person or audience.
	 *
	 * @property suggestedGender
	 * @type Text
	 */
	public String suggestedGender;
	/**
	 * Schema.org/requiredMaxAge
	 * Audiences defined by a person's maximum age.
	 *
	 * @property requiredMaxAge
	 * @type Integer
	 */
	public Integer requiredMaxAge;
	/**
	 * Schema.org/suggestedMinAge
	 * Minimal age recommended for viewing content.
	 *
	 * @property suggestedMinAge
	 * @type Number
	 */
	public Double suggestedMinAge;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PeopleAudience() {
		context = "http://schema.org/";
		type = "PeopleAudience";
	}

}