package org.schema;

import org.stjs.javascript.Array;

/**
 * Schema.org/Action.
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
	public String endTime;
	public String startTime;
	public EntryPoint target;
	public String error;
	public String instrument;
	public String location;
	public String object;
	public Array<String> participant;
	public String result;
}
