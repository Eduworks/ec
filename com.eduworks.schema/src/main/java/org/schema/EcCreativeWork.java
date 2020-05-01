package org.schema;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Function0;

public class EcCreativeWork extends CreativeWork {

	/**
	 * Retrieves a creative work from it's server asynchronously
	 *
	 * @param {String}            id
	 *                            ID of the creative work to retrieve from the server
	 * @param {Callback1<String>} success
	 *                            Callback triggered after retrieving the creative work,
	 *                            returns the creative work retrieved
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error retrieving creative work
	 * @memberOf EcCreativeWork
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcCreativeWork> success, final Callback2<String, Integer> failure) {
		EcRepository.getAs(id,new EcCreativeWork(),success,failure);
	}

	/**
	 * Retrieves a creative work from it's server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the creative work to retrieve
	 * @return EcCreativeWork
	 * The creative work retrieved
	 * @memberOf EcCreativeWork
	 * @method getBlocking
	 * @static
	 */
	public static EcCreativeWork getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcCreativeWork());
	}

	/**
	 * Searches a repository for creative works that match the search query
	 *
	 * @param {EcRepository}                    repo
	 *                                          Repository to search using the query
	 * @param {String}                          query
	 *                                          Query string to pass to the search web service
	 * @param {Callback1<Array<EcCreativeWork>> success
	 *                                          Callback triggered after completing the search, returns the results
	 * @param {Callback1<String>}               failure
	 *                                          Callback triggered if error searching
	 * @param {Object}                          paramObj
	 *                                          Parameter object for search
	 * @memberOf EcCreativeWork
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcCreativeWork>> success, Callback2<String, Integer> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcCreativeWork();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
	}
}
