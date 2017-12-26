package org.w3.skos;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;

/**
 * Created by fray on 11/29/17.
 */
public class EcConceptScheme extends ConceptScheme {
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
	public static void get(String id, final Callback1<EcConceptScheme> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcConceptScheme scheme = new EcConceptScheme();

				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();

					EcEncryptedValue.encryptOnSave(p1.id, true);
				}
				if (p1.isAny(scheme.getTypes())) {
					scheme.copyFrom(p1);

					if (success != null)
						success.$invoke(scheme);
				} else {
					String msg = "Resultant object is not a concept scheme.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}

			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				if (failure != null)
					failure.$invoke(p1);
			}
		});
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
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 == null) return null;
		EcConceptScheme scheme = new EcConceptScheme();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(scheme.getTypes())) {
			scheme.copyFrom(p1);
			return scheme;
		} else {
			return null;
		}
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
	public static void search(EcRepository repo, String query, final Callback1<Array<EcConceptScheme>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = "";
		queryAdd = new EcConceptScheme().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcConceptScheme> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {

						EcConceptScheme scheme = new EcConceptScheme();
						if (p1.$get(i).isAny(scheme.getTypes())) {
							scheme.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcConceptScheme.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								scheme.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(scheme.id, true);
							}
						}

						ret.$set(i, scheme);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

}
