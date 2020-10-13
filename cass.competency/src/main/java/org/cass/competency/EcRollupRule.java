package org.cass.competency;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.RollupRule;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Function0;

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
	public static void get(String id, final Callback1<EcRollupRule> success, final Callback2<String, Integer> failure) {
		EcRepository.getAs(id,new EcRollupRule(),success,failure);
	}
	public static EcRollupRule getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcRollupRule());
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
	 * @memberOf EcRollupRule
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcRollupRule>> success, Callback2<String, Integer> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcRollupRule();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
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
	public void save(Callback1<String> success, Callback2<String, Integer> failure, EcRepository repo) {
		if (rule == null || rule == "") {
			String msg = "RollupRule Rule cannot be empty";
			if (failure != null)
				failure.$invoke(msg, 400);
			else
				Global.console.error(msg);
			return;
		}

		if (competency == null || competency == "") {
			String msg = "RollupRule's Competency cannot be empty";
			if (failure != null)
				failure.$invoke(msg, 400);
			else
				Global.console.error(msg);
			return;
		}

		if (repo == null)
			EcRepository.save(this, success, failure);
		else
			repo.saveTo(this, success, failure);
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
	public void _delete(Callback1<String> success, Callback2<String, Integer> failure) {
		EcRepository.DELETE(this, success, failure);
	}
}
