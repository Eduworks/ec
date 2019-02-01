package org.schema;

/**
 * Schema.org/Question
 * A specific question - e.g. from a user seeking answers online, or collected in a Frequently Asked Questions (FAQ) document.
 *
 * @author schema.org
 * @class Question
 * @module org.schema
 * @extends CreativeWork
 */
public class Question extends CreativeWork {
	/**
	 * Schema.org/answerCount
	 * The number of answers this question has received.
	 *
	 * @property answerCount
	 * @type Integer
	 */
	public Integer answerCount;
	/**
	 * Schema.org/acceptedAnswer
	 * The answer that has been accepted as best, typically on a Question/Answer site. Sites vary in their selection mechanisms, e.g. drawing on community opinion and/or the view of the Question author.
	 *
	 * @property acceptedAnswer
	 * @type Answer
	 */
	public Answer acceptedAnswer;
	/**
	 * Schema.org/upvoteCount
	 * The number of upvotes this question, answer or comment has received from the community.
	 *
	 * @property upvoteCount
	 * @type Integer
	 */
	public Integer upvoteCount;
	/**
	 * Schema.org/suggestedAnswer
	 * An answer (possibly one of several, possibly incorrect) to a Question, e.g. on a Question/Answer site.
	 *
	 * @property suggestedAnswer
	 * @type Answer
	 */
	public Answer suggestedAnswer;
	/**
	 * Schema.org/downvoteCount
	 * The number of downvotes this question, answer or comment has received from the community.
	 *
	 * @property downvoteCount
	 * @type Integer
	 */
	public Integer downvoteCount;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Question() {
		context = "http://schema.org/";
		type = "Question";
	}

}