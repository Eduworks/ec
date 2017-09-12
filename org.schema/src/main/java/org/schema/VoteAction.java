package org.schema;

/**
 * Schema.org/VoteAction
 * The act of expressing a preference from a fixed/finite/structured set of choices/options.
 * @author schema.org
 * @class VoteAction
 * @module org.schema
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