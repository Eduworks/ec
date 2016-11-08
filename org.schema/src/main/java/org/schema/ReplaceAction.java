package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReplaceAction
 * The act of editing a recipient by replacing an old object with a new object.
 * @author schema.org
 * @class ReplaceAction
 * @module org.schema
 * @extends UpdateAction
 */
public class ReplaceAction extends UpdateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReplaceAction()
	{
		context="http://schema.org/";
		type="ReplaceAction";
	}

	/**
	 * Schema.org/replacer
	 * A sub property of object. The object that replaces.
	 * @property replacer
	 * @type Thing
	 */
	public Thing replacer;

	/**
	 * Schema.org/replacee
	 * A sub property of object. The object that is being replaced.
	 * @property replacee
	 * @type Thing
	 */
	public Thing replacee;

}