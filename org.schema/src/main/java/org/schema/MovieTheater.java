package org.schema;

/**
 * Schema.org/MovieTheater
 * A movie theater.
 *
 * @author schema.org
 * @class MovieTheater
 * @module org.schema
 * @extends EntertainmentBusiness
 */
public class MovieTheater extends EntertainmentBusiness {
	/**
	 * Schema.org/screenCount
	 * The number of screens in the movie theater.
	 *
	 * @property screenCount
	 * @type Number
	 */
	public Double screenCount;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MovieTheater() {
		context = "http://schema.org/";
		type = "MovieTheater";
	}

}