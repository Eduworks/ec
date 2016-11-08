package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

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