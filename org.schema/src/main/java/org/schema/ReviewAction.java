package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReviewAction
 * The act of producing a balanced opinion about the object for an audience. An agent reviews an object with participants resulting in a review.
 * @author schema.org
 * @module schema.org
 * @class ReviewAction
 * @extends AssessAction
 */
public class ReviewAction extends AssessAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReviewAction()
	{
		context="http://schema.org/";
		type="ReviewAction";
	}

	/**
	 * Schema.org/resultReview
	 * A sub property of result. The review that resulted in the performing of the action.
	 * @property resultReview
	 * @type Review
	 */
	public Review resultReview;

}