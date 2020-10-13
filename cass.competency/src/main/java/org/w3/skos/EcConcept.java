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
public class EcConcept extends Concept {

	public static Object template;

	public EcConcept() {
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
	 * Retrieves a concept from it's server asynchronously
	 *
	 * @param {String}            id
	 *                            ID of the concept to retrieve from the server
	 * @param {Callback1<String>} success
	 *                            Callback triggered after retrieving the concept,
	 *                            returns the concept retrieved
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error retrieving concept
	 * @memberOf EcConcept
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcConcept> success, final Callback2<String, Integer> failure) {
		EcRepository.getAs(id,new EcConcept(),success,failure);
	}

	/**
	 * Retrieves a concept from it's server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the concept to retrieve
	 * @return EcConcept
	 * The concept retrieved
	 * @memberOf EcConcept
	 * @method getBlocking
	 * @static
	 */
	public static EcConcept getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcConcept());
	}

	/**
	 * Searches a repository for competencies that match the search query
	 *
	 * @param {EcRepository}                  repo
	 *                                        Repository to search using the query
	 * @param {String}                        query
	 *                                        Query string to pass to the search web service
	 * @param {Callback1<Array<EcConcept>> success
	 *                                        Callback triggered after completing the search, returns the results
	 * @param {Callback1<String>}             failure
	 *                                        Callback triggered if error searching
	 * @param {Object}                        paramObj
	 *                                        Parameter object for search
	 * @memberOf EcConcept
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcConcept>> success, Callback2<String, Integer> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcConcept();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
	}

}
