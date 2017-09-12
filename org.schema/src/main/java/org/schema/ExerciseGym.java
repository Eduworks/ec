package org.schema;

/**
 * Schema.org/ExerciseGym
 * A gym.
 * @author schema.org
 * @class ExerciseGym
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class ExerciseGym extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ExerciseGym()
	{
		context="http://schema.org/";
		type="ExerciseGym";
	}

}