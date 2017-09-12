package org.schema;

/**
 * Schema.org/ExerciseAction
 * The act of participating in exertive activity for the purposes of improving health and fitness.
 * @author schema.org
 * @class ExerciseAction
 * @module org.schema
 * @extends PlayAction
 */
public class ExerciseAction extends PlayAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ExerciseAction()
	{
		context="http://schema.org/";
		type="ExerciseAction";
	}

	/**
	 * Schema.org/opponent
	 * A sub property of participant. The opponent on this action.
	 * @property opponent
	 * @type Person
	 */
	public Person opponent;

	/**
	 * Schema.org/exerciseCourse
	 * A sub property of location. The course where this action was taken.
	 * @property exerciseCourse
	 * @type Place
	 */
	public Place exerciseCourse;

	/**
	 * Schema.org/fromLocation
	 * A sub property of location. The original location of the object or the agent before the action.
	 * @property fromLocation
	 * @type Place
	 */
	public Place fromLocation;

	/**
	 * Schema.org/course
	 * A sub property of location. The course where this action was taken.
	 * @property course
	 * @type Place
	 */
	public Place course;

	/**
	 * Schema.org/toLocation
	 * A sub property of location. The final location of the object or the agent after the action.
	 * @property toLocation
	 * @type Place
	 */
	public Place toLocation;

	/**
	 * Schema.org/distance
	 * The distance travelled, e.g. exercising or travelling.
	 * @property distance
	 * @type Distance
	 */
	public Distance distance;

	/**
	 * Schema.org/sportsActivityLocation
	 * A sub property of location. The sports activity location where this action occurred.
	 * @property sportsActivityLocation
	 * @type SportsActivityLocation
	 */
	public SportsActivityLocation sportsActivityLocation;

	/**
	 * Schema.org/sportsEvent
	 * A sub property of location. The sports event where this action occurred.
	 * @property sportsEvent
	 * @type SportsEvent
	 */
	public SportsEvent sportsEvent;

	/**
	 * Schema.org/sportsTeam
	 * A sub property of participant. The sports team that participated on this action.
	 * @property sportsTeam
	 * @type SportsTeam
	 */
	public SportsTeam sportsTeam;

}