package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EndorseAction
 * An agent approves/certifies/likes/supports/sanction an object.
 * @author schema.org
 * @class EndorseAction
 * @module org.schema
 * @extends ReactAction
 */
public class EndorseAction extends ReactAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EndorseAction()
	{
		context="http://schema.org/";
		type="EndorseAction";
	}

	/**
	 * Schema.org/endorsee
	 * A sub property of participant. The person/organization being supported.
	 * @property endorsee
	 * @type schema,Organization | schema,Person
	 */
	public Object endorsee;

}