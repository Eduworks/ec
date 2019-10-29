package com.eduworks.schema.question;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

public class EcQuiz extends CreativeWork {

	public static String myType = "http://schema.eduworks.com/0.1/Quiz";
	public Integer duration;
	public Array<String> question;
	public EcQuiz() {
		type = "Quiz";
		context = "http://schema.eduworks.com/0.1/";
	}

	/**
	 * Searches a repository for quizzes that match the search query
	 *
	 * @param {EcRepository}          repo Repository to search using the query
	 * @param {String}                query Query string to pass to the search web service
	 * @param {Callback1<Array<Quiz>> success Callback triggered after
	 *                                completing the search, returns the results
	 * @param {Callback1<String>}     failure Callback triggered if error searching
	 * @param {Object}                paramObj Parameter object for search
	 * @param start
	 * @param size
	 * @memberOf Quiz
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcQuiz>> success, Callback1<String> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcQuiz();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
	}

}
