package org.schema;

/**
 * Schema.org/Action
 * An action performed by a direct agent and indirect participants upon a direct object. Optionally happens at a location with the help of an inanimate instrument. The execution of the action may produce a result. Specific action sub-type documentation specifies the exact expectation of each argument/role.\n\nSee also [blog post](http://blog.schema.org/2014/04/announcing-schemaorg-actions.html) and [Actions overview document](schema:docs/actions.html).
 *
 * @author schema.org
 * @class Action
 * @module org.schema
 * @extends Thing
 */
public class Action extends Thing {
	/**
	 * Schema.org/result
	 * The result produced in the action. e.g. John wrote *a book*.
	 *
	 * @property result
	 * @type Thing
	 */
	public Thing result;
	/**
	 * Schema.org/actionStatus
	 * Indicates the current disposition of the Action.
	 *
	 * @property actionStatus
	 * @type ActionStatusType
	 */
	public ActionStatusType actionStatus;
	/**
	 * Schema.org/target
	 * Indicates a target EntryPoint for an Action.
	 *
	 * @property target
	 * @type EntryPoint
	 */
	public EntryPoint target;
	/**
	 * Schema.org/agent
	 * The direct performer or driver of the action (animate or inanimate). e.g. *John* wrote a book.
	 *
	 * @property agent
	 * @type Person
	 */
	public Person agent;
	/**
	 * Schema.org/startTime
	 * The startTime of something. For a reserved event or service (e.g. FoodEstablishmentReservation), the time that it is expected to start. For actions that span a period of time, when the action was performed. e.g. John wrote a book from *January* to December.\n\nNote that Event uses startDate/endDate instead of startTime/endTime, even when describing dates with times. This situation may be clarified in future revisions.
	 *
	 * @property startTime
	 * @type DateTime
	 */
	public String startTime;
	/**
	 * Schema.org/endTime
	 * The endTime of something. For a reserved event or service (e.g. FoodEstablishmentReservation), the time that it is expected to end. For actions that span a period of time, when the action was performed. e.g. John wrote a book from January to *December*.\n\nNote that Event uses startDate/endDate instead of startTime/endTime, even when describing dates with times. This situation may be clarified in future revisions.
	 *
	 * @property endTime
	 * @type DateTime
	 */
	public String endTime;
	/**
	 * Schema.org/participant
	 * Other co-agents that participated in the action indirectly. e.g. John wrote a book with *Steve*.
	 *
	 * @property participant
	 * @type Person
	 */
	public Person participant;
	/**
	 * Schema.org/instrument
	 * The object that helped the agent perform the action. e.g. John wrote a book with *a pen*.
	 *
	 * @property instrument
	 * @type Thing
	 */
	public Thing instrument;
	/**
	 * Schema.org/object
	 * The object upon which the action is carried out, whose state is kept intact or changed. Also known as the semantic roles patient, affected or undergoer (which change their state) or theme (which doesn't). e.g. John read *a book*.
	 *
	 * @property object
	 * @type Thing
	 */
	public Thing object;
	/**
	 * Schema.org/error
	 * For failed actions, more information on the cause of the failure.
	 *
	 * @property error
	 * @type Thing
	 */
	public Thing error;
	/**
	 * Schema.org/location
	 * The location of for example where the event is happening, an organization is located, or where an action takes place.
	 *
	 * @property location
	 * @type PostalAddress
	 */
	public PostalAddress location;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Action() {
		context = "http://schema.org/";
		type = "Action";
	}

}