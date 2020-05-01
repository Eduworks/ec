package org.w3.skos;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Function0;

/**
 * Created by fray on 11/29/17.
 */
public class EcConceptScheme extends ConceptScheme {

	public static Object template;

	public EcConceptScheme() {
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		if (template != null) {
			Map<String, Object> you = JSObjectAdapter.$properties(template);
			for (String key : you) {
				if (JSGlobal.typeof(you.$get(key)) != "function")
					me.$put(key.replace("@", ""), you.$get(key));
			}
		}
	}
	/**
	 * Retrieves a concept scheme from the server, specified by the ID
	 *
	 * @param {String}                 id
	 *                                 ID of the concept scheme to retrieve
	 * @param {Callback1<EcConceptScheme>} success
	 *                                 Callback triggered after successfully retrieving the concept scheme,
	 *                                 returns the retrieved concept scheme
	 * @param {Callback1<String>}      failure
	 *                                 Callback triggered if an error occurs while retrieving the concept scheme
	 * @memberOf EcConceptScheme
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcConceptScheme> success, final Callback2<String, Integer> failure) {
		EcRepository.getAs(id,new EcConceptScheme(),success,failure);
	}

	/**
	 * Retrieves a concept scheme from the server in a blocking fashion, specified by the ID
	 *
	 * @param {String}                 id
	 *                                 ID of the concept scheme to retrieve
	 * @param {Callback1<EcConceptScheme>} success
	 *                                 Callback triggered after successfully retrieving the concept scheme,
	 *                                 returns the retrieved concept scheme
	 * @param {Callback1<String>}      failure
	 *                                 Callback triggered if an error occurs while retrieving the concept scheme
	 * @memberOf EcConceptScheme
	 * @method getBlocking
	 * @static
	 */
	public static EcConceptScheme getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcConceptScheme());
	}

	/**
	 * Searches the repository given for concept schemes using the query passed in
	 *
	 * @param {EcRepository}                 repo
	 *                                       Repository to search for concept schemes
	 * @param {String}                       query
	 *                                       Query string used to search for a concept scheme
	 * @param {Callback1<Array<EcConceptScheme>} success
	 *                                       Callback triggered when the search successfully returns,
	 *                                       returns search results
	 * @param {Callback1<String>}            failure
	 *                                       Callback triggered if an error occurs while searching
	 * @param {Object}                       paramObj
	 *                                       Parameter object for search
	 * @memberOf EcConceptScheme
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcConceptScheme>> success, Callback2<String, Integer> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcConceptScheme();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
	}

}
