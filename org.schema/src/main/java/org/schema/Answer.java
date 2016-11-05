package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Answer
 * An answer offered to a question; perhaps correct, perhaps opinionated or wrong.
 * @author schema.org
 * @module schema.org
 * @class Answer
 * @extends Comment
 */
public class Answer extends Comment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Answer()
	{
		context="http://schema.org/";
		type="Answer";
	}

}