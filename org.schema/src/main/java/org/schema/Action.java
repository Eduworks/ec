package org.schema;

import org.stjs.javascript.Array;

public class Action extends Thing
{
	protected Action()
	{
		schema = "http://schema.org/";
		type = "http://schema.org/Action";
	}

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
