package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VoteAction
 * The act of expressing a preference from a fixed/finite/structured set of choices/options.
 * @author schema.org
 * @module schema.org
 * @class VoteAction
 * @extends ChooseAction
 */
public class VoteAction extends ChooseAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VoteAction()
	{
		context="http://schema.org/";
		type="VoteAction";
	}

	/**
	 * Schema.org/candidate
	 * A sub property of object. The candidate subject of this action.
	 * @property candidate
	 * @type Person
	 */
	public Person candidate;

}