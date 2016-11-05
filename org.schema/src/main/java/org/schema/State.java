package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/State
 * A state or province of a country.
 * @author schema.org
 * @module schema.org
 * @class State
 * @extends AdministrativeArea
 */
public class State extends AdministrativeArea
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public State()
	{
		context="http://schema.org/";
		type="State";
	}

}