package org.w3.skos;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;

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
	public static void get(String id, final Callback1<EcConcept> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				if (p1 instanceof EcConcept)
					if (success != null) {
						success.$invoke((EcConcept) p1);
						return;
					}

				EcConcept concept = new EcConcept();

				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();

					EcEncryptedValue.encryptOnSave(p1.id, true);

				}
				if (p1.isAny(concept.getTypes())) {
					concept.copyFrom(p1);
					if (EcRepository.caching) {
						JSObjectAdapter.$put(EcRepository.cache, concept.shortId(), concept);
						JSObjectAdapter.$put(EcRepository.cache, concept.id, concept);
					}
					if (success != null)
						success.$invoke(concept);
				} else {
					String msg = "Retrieved object was not a concept";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}

			}

		}, failure);
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
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 == null)
			return null;
		EcConcept concept = new EcConcept();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(concept.getTypes())) {
			concept.copyFrom(p1);

			return concept;
		} else {
			String msg = "Retrieved object was not a concept";
			Global.console.error(msg);
			return null;
		}
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
	public static void search(EcRepository repo, String query, final Callback1<Array<EcConcept>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = "";
		queryAdd = new EcConcept().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcConcept> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						EcConcept comp = new EcConcept();
						if (p1.$get(i).isAny(comp.getTypes())) {
							comp.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcConcept.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								comp.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(comp.id, true);
							}
						}

						ret.$set(i, comp);
					}

					success.$invoke(ret);
				}
			}

		}, failure);

	}

}
