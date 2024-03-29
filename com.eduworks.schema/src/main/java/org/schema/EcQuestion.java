package org.schema;

import com.eduworks.ec.array.EcArray;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

public class EcQuestion extends Question {

	public static final String MULTIPLE_CHOICE = "Multiple Choice";
	public static final String MULTIPLE_SELECT = "Multiple Select";
	public static final String SHORT_ANSWER = "Short Answer";
	public static final String FILL_IN_THE_BLANK = "Fill in the Blank";
	public static final String ESSAY_OR_SHORT_ANSWER = "Essay or Short Answer";
	public static final String HAND_GRADED_ESSAY = "Hand-graded Essay";

	/**
	 * Searches a repository for questions that match the search query
	 *
	 * @param {EcRepository}          repo Repository to search using the query
	 * @param {String}                query Query string to pass to the search web service
	 * @param {Callback1<Array<Quiz>> success Callback triggered after
	 *                                completing the search, returns the results
	 * @param {Callback1<String>}     failure Callback triggered if error searching
	 * @param {Object}                paramObj Parameter object for search
	 * @memberOf EcQuestion
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcQuestion>> success, Callback1<String> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcQuestion();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
	}

	/**
	 * Heuristic method of determining how this question should be asked.
	 *
	 * @return
	 */
	public String getQuestionType() {
		Array<String> acceptedAnswers = acceptedAnswers();
		if (acceptedAnswers == null) {
			if (canEdit(EcIdentityManager.ids.$get(0).ppk.toPk())) {
				return HAND_GRADED_ESSAY;
			} else {
				return ESSAY_OR_SHORT_ANSWER;
			}
		}
		int m = acceptedAnswers.$length();
		if (m == 0) {
			return HAND_GRADED_ESSAY;
		}
		if (suggestedAnswer == null) {
			if (text != null && text.indexOf("__") != -1) {
				return FILL_IN_THE_BLANK;
			}
			return SHORT_ANSWER;
		}
		int l = ((Array<String>) (Object) suggestedAnswer).$length();
		if (l == 0) {
			if (text != null && text.indexOf("__") != -1) {
				return FILL_IN_THE_BLANK;
			}
			return SHORT_ANSWER;
		}
		if (m > 1) {
			return MULTIPLE_SELECT;
		}
		if (l > 0) {
			return MULTIPLE_CHOICE;
		}
		return "Not sure.";
	}

	public void cementAnswerId(String id) {
		if (acceptedAnswer != null) {
			if (!EcArray.isArray(acceptedAnswer)) {
				throw new RuntimeException("Accepted Answer is not Array");
			}
			Array<String> ary = (Array<String>) (Object) acceptedAnswer;
			for (int i = 0; i < ary.$length(); i++) {
				if (EcRemoteLinkedData.trimVersionFromUrl(ary.$get(i)) == EcRemoteLinkedData.trimVersionFromUrl(id)) {
					ary.$set(i, id);
				}
			}
		}
		if (suggestedAnswer != null) {
			if (!EcArray.isArray(suggestedAnswer)) {
				throw new RuntimeException("Suggested Answer is not Array");
			}
			Array<String> ary = (Array<String>) (Object) suggestedAnswer;
			for (int i = 0; i < ary.$length(); i++) {
				if (EcRemoteLinkedData.trimVersionFromUrl(ary.$get(i)) == EcRemoteLinkedData.trimVersionFromUrl(id)) {
					ary.$set(i, id);
				}
			}
		}
	}

	public Array<String> acceptedAnswers() {
		if (acceptedAnswer == null) {
			return new Array<>();
		}
		return (Array<String>) (Object) acceptedAnswer;
	}

	public Array<String> suggestedAnswers() {
		if (suggestedAnswer == null) {
			return new Array<>();
		}
		return (Array<String>) (Object) suggestedAnswer;
	}

	public void addAcceptedAnswer(EcAnswer answer) {
		if (acceptedAnswer == null) {
			JSObjectAdapter.$put(this, "acceptedAnswer", new Array<String>());
		}
		if (!EcArray.isArray(acceptedAnswer)) {
			throw new RuntimeException("Accepted Answer is not Array");
		}
		Array<String> ary = (Array<String>) (Object) acceptedAnswer;
		ary.push(answer.id);
	}

	public void addSuggestedAnswer(EcAnswer answer) {
		if (suggestedAnswer == null) {
			JSObjectAdapter.$put(this, "suggestedAnswer", new Array<String>());
		}
		if (!EcArray.isArray(suggestedAnswer)) {
			throw new RuntimeException("Suggested Answer is not Array");
		}
		Array<String> ary = (Array<String>) (Object) suggestedAnswer;
		ary.push(answer.id);
	}

	public void removeSuggestedAnswerById(String id) {
		if (suggestedAnswer == null) {
			return;
		}

		if (!EcArray.isArray(suggestedAnswer)) {
			throw new RuntimeException("Suggested Answer is not Array");
		}
		Array<String> ary = (Array<String>) (Object) suggestedAnswer;
		for (int i = 0; i < ary.$length(); i++) {
			if (EcRemoteLinkedData.trimVersionFromUrl(ary.$get(i)) == EcRemoteLinkedData.trimVersionFromUrl(id)) {
				ary.splice(i, 1);
			}
		}
	}

	public void removeAcceptedAnswerById(String id) {
		if (acceptedAnswer == null) {
			return;
		}

		if (!EcArray.isArray(acceptedAnswer)) {
			throw new RuntimeException("Accepted Answer is not Array");
		}
		Array<String> ary = (Array<String>) (Object) acceptedAnswer;
		for (int i = 0; i < ary.$length(); i++) {
			if (EcRemoteLinkedData.trimVersionFromUrl(ary.$get(i)) == EcRemoteLinkedData.trimVersionFromUrl(id)) {
				ary.splice(i, 1);
			}
		}
	}

}
