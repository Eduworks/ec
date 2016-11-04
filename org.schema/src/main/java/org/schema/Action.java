package org.schema;

import org.stjs.javascript.Array;

/**
 * Schema.org/Action
 * @author schema.org
 * @class Action
 */
public class Action extends Thing
{
	protected Action()
	{
		context = "http://schema.org/";
		type = "Action";
	}

	/**
	 * Schema.org/agent
	 * @property agent
	 * @type Person | URL
	 */
	public String agent;
	/**
	 * Schema.org/endTime
	 * @property endTime
	 * @type DateTime
	 */
	public String endTime;
	/**
	 * Schema.org/startTime
	 * @property startTime
	 * @type DateTime
	 */
	public String startTime;
	/**
	 * Schema.org/target
	 * @property target
	 * @type EntryPoint
	 */
	public EntryPoint target;
	/**
	 * Schema.org/error
	 * @property error
	 * @type Thing
	 */
	public String error;
	/**
	 * Schema.org/instrument
	 * @property instrument
	 * @type Thing
	 */
	public String instrument;
	/**
	 * Schema.org/location
	 * @property location
	 * @type Place | PostalAddress | string
	 */
	public String location;
	/**
	 * Schema.org/object
	 * @property object
	 * @type Thing
	 */
	public String object;
	/**
	 * Schema.org/participant
	 * @property participant
	 * @type Participant
	 */
	public Array<String> participant;
	/**
	 * Schema.org/result
	 * @property result
	 * @type Thing
	 */
	public String result;
}
