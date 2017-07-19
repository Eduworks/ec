package org.angles.schema.angles;

import org.schema.Question;

/**
 * Created by dbrown on 7/18/17.
 */
public class Question extends Question {

	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Question()
	{
		context="http://schema.eduworks.com/angles/0.1/";
		type="Question";
	}

}
