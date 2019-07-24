package org.schema;

/**
 * Schema.org/ParentAudience
 * A set of characteristics describing parents, who can be interested in viewing some content.
 *
 * @author schema.org
 * @class ParentAudience
 * @module org.schema
 * @extends PeopleAudience
 */
public class ParentAudience extends PeopleAudience {
	/**
	 * Schema.org/childMaxAge
	 * Maximal age of the child.
	 *
	 * @property childMaxAge
	 * @type Number
	 */
	public Double childMaxAge;
	/**
	 * Schema.org/childMinAge
	 * Minimal age of the child.
	 *
	 * @property childMinAge
	 * @type Number
	 */
	public Double childMinAge;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ParentAudience() {
		context = "http://schema.org/";
		type = "ParentAudience";
	}

}