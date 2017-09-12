package org.schema;

/**
 * Schema.org/Answer
 * An answer offered to a question; perhaps correct, perhaps opinionated or wrong.
 * @author schema.org
 * @class Answer
 * @module org.schema
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