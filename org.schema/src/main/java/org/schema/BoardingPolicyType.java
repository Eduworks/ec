package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BoardingPolicyType
 * A type of boarding policy used by an airline.
 * @author schema.org
 * @module schema.org
 * @class BoardingPolicyType
 * @extends Enumeration
 */
public class BoardingPolicyType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BoardingPolicyType()
	{
		context="http://schema.org/";
		type="BoardingPolicyType";
	}

}