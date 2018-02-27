package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.RollupRule;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;

/**
 * Implementation of a Rollup Rule object with methods for interacting with CASS
 * services on a server.
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class EcRollupRule
 * @constructor
 * @extends RollupRule
 */
public class EcRollupRule extends RollupRule {
	/**
	 * Retrieves a rollup rule from the server
	 *
	 * @param {String}                  id
	 *                                  ID of the rollup rule to retrieve
	 * @param {Callback1<EcRollupRule>} success
	 *                                  Callback triggered on successful retrieving rollup rule,
	 *                                  returns the rollup rule
	 * @param {Callback1<String>}       failure
	 *                                  Callback triggered if error retrieving rollup rule
	 * @memberOf EcRollupRule
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcRollupRule> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				if (success == null)
					return;
				if (!p1.isA(EcRollupRule.myType)) {
					if (failure != null)
						failure.$invoke("Resultant object is not a level.");
					return;
				}
				EcRollupRule c = new EcRollupRule();
				c.copyFrom(p1);
				success.$invoke(c);
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
	 * Searches for levels with a string query
	 *
	 * @param {EcRepository}                   repo
	 *                                         Repository to search for levels
	 * @param {String}                         query
	 *                                         query string to use in search
	 * @param {Callback1<Array<EcRollupRule>>} success
	 *                                         Callback triggered when searches successfully
	 * @param {Callback1<String>}              failure
	 *                                         Callback triggered if an error occurs while searching
	 * @param {Object}                         paramObj
	 *                                         Search parameters object to pass in
	 * @param size
	 * @param start
	 * @memberOf EcRollupRule
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcRollupRule>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = "";
		queryAdd = new EcRollupRule().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcRollupRule> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						EcRollupRule rule = new EcRollupRule();
						if (p1.$get(i).isAny(rule.getTypes())) {
							rule.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcRollupRule.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								rule.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(rule.id, true);
							}
						}

						ret.$set(i, rule);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

	/**
	 * Method for setting a rollup rule name
	 *
	 * @param name
	 * @memberOf EcRollupRule
	 * @method setName
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method for setting a rollup rule description
	 *
	 * @param {String} description
	 * @memberOf EcRollupRule
	 * @method setDescription
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Saves this rollup rules details on the server specified by its ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successful save of rollup rule
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error saving rollup rule
	 * @memberOf EcRollupRule
	 * @method save
	 */
	public void save(Callback1<String> success, Callback1<String> failure) {
		if (rule == null || rule == "") {
			String msg = "RollupRule Rule cannot be empty";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (competency == null || competency == "") {
			String msg = "RollupRule's Competency cannot be empty";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		EcRepository.save(this, success, failure);
	}

	/**
	 * Deletes this rollup rule from the server specified by it's ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successful deleting the rollup rle
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error deleting the rollup rule
	 * @memberOf EcRollupRule
	 * @method _delete
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}
}
