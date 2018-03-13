package org.cass.competency;

import com.eduworks.ec.remote.EcRemote;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Framework;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;

/**
 * Implementation of a Framework object with methods for interacting with CASS
 * services on a server.
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class EcFramework
 * @constructor
 * @extends Framework
 */
public class EcFramework extends Framework {

	static Map<String, Boolean> relDone = JSCollections.$map();
	static Map<String, Boolean> levelDone = JSCollections.$map();
	public static Object template;

	public EcFramework() {
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
	 * Retrieves a framework from the server, specified by the ID
	 *
	 * @param {String}                 id
	 *                                 ID of the framework to retrieve
	 * @param {Callback1<EcFramework>} success
	 *                                 Callback triggered after successfully retrieving the framework,
	 *                                 returns the retrieved framework
	 * @param {Callback1<String>}      failure
	 *                                 Callback triggered if an error occurs while retrieving the framework
	 * @memberOf EcFramework
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcFramework> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcFramework framework = new EcFramework();

				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();

					EcEncryptedValue.encryptOnSave(p1.id, true);
				}
				if (p1.isAny(framework.getTypes())) {
					framework.copyFrom(p1);

					if (success != null)
						success.$invoke(framework);
				} else {
					String msg = "Resultant object is not a framework.";
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
	 * Retrieves a framework from the server in a blocking fashion, specified by the ID
	 *
	 * @param {String}                 id
	 *                                 ID of the framework to retrieve
	 * @param {Callback1<EcFramework>} success
	 *                                 Callback triggered after successfully retrieving the framework,
	 *                                 returns the retrieved framework
	 * @param {Callback1<String>}      failure
	 *                                 Callback triggered if an error occurs while retrieving the framework
	 * @memberOf EcFramework
	 * @method getBlocking
	 * @static
	 */
	public static EcFramework getBlocking(String id) {
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 == null) return null;
		EcFramework framework = new EcFramework();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(framework.getTypes())) {
			framework.copyFrom(p1);
			return framework;
		} else {
			return null;
		}
	}

	/**
	 * Searches the repository given for frameworks using the query passed in
	 *
	 * @param {EcRepository}                 repo
	 *                                       Repository to search for frameworks
	 * @param {String}                       query
	 *                                       Query string used to search for a framework
	 * @param {Callback1<Array<EcFramework>} success
	 *                                       Callback triggered when the search successfully returns,
	 *                                       returns search results
	 * @param {Callback1<String>}            failure
	 *                                       Callback triggered if an error occurs while searching
	 * @param {Object}                       paramObj
	 *                                       Parameter object for search
	 * @memberOf EcFramework
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcFramework>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = "";
		queryAdd = new EcFramework().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcFramework> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {

						EcFramework framework = new EcFramework();
						if (p1.$get(i).isAny(framework.getTypes())) {
							framework.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcFramework.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								framework.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(framework.id, true);
							}
						}

						ret.$set(i, framework);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

	/**
	 * Adds the competency ID specified to the frameworks list of competency IDs
	 *
	 * @param {String} id
	 *                 ID of the competency to add
	 * @memberOf EcFramework
	 * @method addCompetency
	 */
	public void addCompetency(String id) {
		id = trimVersionFromUrl(id);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (trimVersionFromUrl(competency.$get(i)).equals(id))
				return;
		competency.push(id);
	}

	/**
	 * Removes a competency ID from the framework's list, also removes any
	 * levels and relations associated with that competency
	 * <p>
	 * TODO: remove rollup rules? should we add flag to remove these extras
	 *
	 * @param {String}            id
	 *                            ID of the competency to remove
	 * @param {Callback1<String>} success
	 *                            Callback triggered after succesfully removing the competency and levels and relationships
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs when removing competency and levels and relationships
	 * @memberOf EcFramework
	 * @method removeCompetency
	 */
	public void removeCompetency(final String id, final Callback1<String> success, final Callback1<String> failure) {
		final String shortId = trimVersionFromUrl(id);
		if (competency == null)
			competency = new Array<String>();
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).equals(shortId) || competency.$get(i).equals(id))
				competency.splice(i, 1);
		if ((relation == null || relation.$length() == 0) && (level == null || level.$length() == 0))
			if (success != null)
				success.$invoke("");

		relDone.$put(id, false);
		levelDone.$put(id, false);

		if (relation != null) {
			removeRelationshipsThatInclude(id, 0, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					if (levelDone.$get(id)) {
						if (success != null)
							success.$invoke(p1);
					} else {
						relDone.$put(id, true);
					}
				}
			}, failure);
		} else {
			relDone.$put(id, true);
		}
		if (level != null) {
			removeLevelsThatInclude(id, 0, new Callback1<String>() {
				@Override
				public void $invoke(String p1) {
					if (relDone.$get(id)) {
						if (success != null)
							success.$invoke(p1);
					} else {
						levelDone.$put(id, true);
					}
				}
			}, failure);
		} else {
			levelDone.$put(id, true);
		}
	}

	/**
	 * Helper method to remove relationships associated with a competency from this framework
	 *
	 * @param {String}            id
	 *                            ID of the competency being removed, to find relationships on
	 * @param {int}               i
	 *                            recursive index parameter
	 * @param {Callback1<String>} success
	 *                            Callback triggered after all relationships in the framework have been checked
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs looking through relationships
	 * @memberOf EcFramework
	 * @method removeRelationshipsThatInclude
	 * @private
	 */
	private void removeRelationshipsThatInclude(final String id, final int i, final Callback1<String> success, final Callback1<String> failure) {
		final String shortId = trimVersionFromUrl(id);
		final EcFramework me = this;
		if (i >= relation.$length() && success != null)
			success.$invoke("");
		else
			EcRepository.get(relation.$get(i), new Callback1<EcRemoteLinkedData>() {
				@Override
				public void $invoke(EcRemoteLinkedData p1) {
					EcAlignment a = null;

					// Wrap this in case there's an error retrieving, will skip that relationship
					try {
						a = new EcAlignment();
						a.copyFrom(p1);
					} catch (Exception e) {
					}

					if (a != null && a.source == shortId || a.target == shortId || a.source == id || a.target == id) {
						me.relation.splice(i, 1);
						me.removeRelationshipsThatInclude(id, i, success, failure);
					} else
						me.removeRelationshipsThatInclude(id, i + 1, success, failure);
				}
			}, failure);
	}

	/**
	 * Helper method to remove levels associated with a competency from this framework
	 *
	 * @param {String}            id
	 *                            ID of the competency being removed, to find levels on
	 * @param {int}               i
	 *                            recursive index parameter
	 * @param {Callback1<String>} success
	 *                            Callback triggered after all levels in the framework have been checked
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs looking through levels
	 * @memberOf EcFramework
	 * @method removeLevelsThatInclude
	 * @private
	 */
	private void removeLevelsThatInclude(final String id, final int i, final Callback1<String> success, final Callback1<String> failure) {
		final String shortId = trimVersionFromUrl(id);
		final EcFramework me = this;
		if (i >= level.$length() && success != null)
			success.$invoke("");
		else
			EcRepository.get(level.$get(i), new Callback1<EcRemoteLinkedData>() {
				@Override
				public void $invoke(EcRemoteLinkedData p1) {
					EcLevel a = new EcLevel();
					a.copyFrom(p1);
					if (a.competency == shortId || a.competency == id) {
						me.level.splice(i, 1);
						me.removeLevelsThatInclude(id, i, success, failure);
					} else
						me.removeLevelsThatInclude(id, i + 1, success, failure);
				}
			}, failure);
	}

	/**
	 * Adds a relation ID to the framework's list of relations
	 *
	 * @param {String} id
	 *                 ID to add to the framework's relation list
	 * @memberOf EcFramework
	 * @method addRelation
	 */
	public void addRelation(String id) {
		id = trimVersionFromUrl(id);
		if (relation == null)
			relation = new Array<String>();
		for (int i = 0; i < relation.$length(); i++)
			if (trimVersionFromUrl(relation.$get(i)).equals(id))
				return;
		relation.push(id);
	}

	/**
	 * Removes a relation ID from the framework's list of relations
	 *
	 * @param {String} id
	 *                 ID to remove from the framework's relation list
	 * @memberOf EcFramework
	 * @method removeCompetency
	 */
	public void removeRelation(String id) {
		id = trimVersionFromUrl(id);
		if (relation == null)
			relation = new Array<String>();
		for (int i = 0; i < relation.$length(); i++)
			if (trimVersionFromUrl(relation.$get(i)).equals(id))
				relation.splice(i, 1);
	}

	/**
	 * Adds a level ID to the framework's list of levels
	 *
	 * @param {String} id
	 *                 ID of the level to add to framework's list
	 * @memberOf EcFramework
	 * @method addLevel
	 */
	public void addLevel(String id) {
		id = trimVersionFromUrl(id);
		if (level == null)
			level = new Array<String>();
		for (int i = 0; i < level.$length(); i++)
			if (trimVersionFromUrl(level.$get(i)).equals(id))
				return;
		level.push(id);
	}

	/**
	 * Removes a level ID from the framework's list of levels
	 *
	 * @param {String} id
	 *                 ID to remove from framework's level list
	 * @memberOf EcFramework
	 * @method removeLevel
	 */
	public void removeLevel(String id) {
		id = trimVersionFromUrl(id);
		if (level == null)
			level = new Array<String>();
		for (int i = 0; i < level.$length(); i++)
			if (trimVersionFromUrl(level.$get(i)).equals(id))
				level.splice(i, 1);
	}

	/**
	 * Adds a rollup rule ID to the framework's list of rollup rules
	 *
	 * @param {String} id
	 *                 ID of the rollup rule to add
	 * @memberOf EcFramework
	 * @method addRollupRule
	 */
	public void addRollupRule(String id) {
		id = trimVersionFromUrl(id);
		if (rollupRule == null)
			rollupRule = new Array<String>();
		for (int i = 0; i < rollupRule.$length(); i++)
			if (trimVersionFromUrl(rollupRule.$get(i)).equals(id))
				return;
		rollupRule.push(id);
	}

	/**
	 * Removes a rollup rule ID from the framework's list of rollup rules
	 *
	 * @param {String} id
	 *                 ID to remove from rollup rule list
	 * @memberOf EcFramework
	 * @method removeRollupRule
	 */
	public void removeRollupRule(String id) {
		id = trimVersionFromUrl(id);
		if (rollupRule == null)
			rollupRule = new Array<String>();
		for (int i = 0; i < rollupRule.$length(); i++)
			if (trimVersionFromUrl(rollupRule.$get(i)).equals(id))
				rollupRule.splice(i, 1);
	}

	/**
	 * Saves this frameworks details on the server specified by it's ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered after successfully saving the framework
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs while saving the framework
	 * @memberOf EcFramework
	 * @method save
	 */
	public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
		if (this.name == null || this.name == "") {
			String msg = "Framework Name Cannot be Empty";

			if (failure != null)
				failure.$invoke(msg);
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
	 * Deletes this framework from the server specified by it's ID
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered if successfully deleted framework
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs when deleting the framework
	 * @memberOf EcFramework
	 * @method _delete
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}

	public void asAsnJson(final Callback1<String> success, final Callback1<String> failure, final String fallbackServerUrl) {
		final String id = this.id;

		String server = getServerBaseUrl();
		if (server != null && server != JSGlobal.undefined && !server.endsWith("/")) {
			server = server + "/";
		}

		EcRemote.getExpectingString(server, "asn?id=" + getGuid(), success, new Callback1<String>() {

			@Override
			public void $invoke(String p1) {

				if (fallbackServerUrl != null && fallbackServerUrl != JSGlobal.undefined) {
					String server = fallbackServerUrl;
					if (!server.endsWith("/")) {
						server = server + "/";
					}
					EcRemote.getExpectingString(server, "asn?id=" + id, success, failure);
				} else {
					failure.$invoke(p1);
				}
			}
		});
	}
}
