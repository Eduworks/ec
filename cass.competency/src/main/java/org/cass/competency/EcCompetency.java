package org.cass.competency;

import com.eduworks.ec.crypto.EcPpk;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.Cass;
import org.cassproject.schema.cass.competency.Competency;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function0;

/**
 * Implementation of a Competency object with methods for interacting with CASS
 * services on a server.
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class EcCompetency
 * @constructor
 * @extends Competency
 */
public class EcCompetency extends Competency {
	static Map<String, Boolean> relDone = JSCollections.$map();
	static Map<String, Boolean> levelDone = JSCollections.$map();
	public static Object template = null;

	public EcCompetency() {
		Map<String, Object> me = JSObjectAdapter.$properties(this);
		if (template != null) {
			Map<String, Object> you = JSObjectAdapter.$properties(template);
			for (String key : you) {
				if (JSGlobal.typeof(you.$get(key)) != "function")
					me.$put(key.replace("@", ""), you.$get(key));
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		return isId(((EcCompetency)obj).id);
	}

	/**
	 * Retrieves a competency from it's server asynchronously
	 *
	 * @param {String}            id
	 *                            ID of the competency to retrieve from the server
	 * @param {Callback1<String>} success
	 *                            Callback triggered after retrieving the competency,
	 *                            returns the competency retrieved
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error retrieving competency
	 * @memberOf EcCompetency
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcCompetency> success, final Callback1<String> failure) {
		EcRepository.getAs(id,new EcCompetency(),success,failure);
	}

	/**
	 * Retrieves a competency from it's server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the competency to retrieve
	 * @return EcCompetency
	 * The competency retrieved
	 * @memberOf EcCompetency
	 * @method getBlocking
	 * @static
	 */
	public static EcCompetency getBlocking(String id) {
		return EcRepository.getBlockingAs(id,new EcCompetency());
	}

	/**
	 * Searches a repository for competencies that match the search query
	 *
	 * @param {EcRepository}                  repo
	 *                                        Repository to search using the query
	 * @param {String}                        query
	 *                                        Query string to pass to the search web service
	 * @param {Callback1<Array<EcCompetency>> success
	 *                                        Callback triggered after completing the search, returns the results
	 * @param {Callback1<String>}             failure
	 *                                        Callback triggered if error searching
	 * @param {Object}                        paramObj
	 *                                        Parameter object for search
	 * @memberOf EcCompetency
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcCompetency>> success, Callback1<String> failure, Object paramObj) {
		EcRepository.searchAs(repo, query, new Function0() {
			@Override
			public Object $invoke() {
				return new EcCompetency();
			}
		},(Callback1<Array>)(Object)success,failure,paramObj);
	}

	/**
	 * Adds a new alignment on the server specified with this competency as its
	 * source and the specified target competency
	 *
	 * @param {EcCompetency}      target
	 *                            Competency to be related with
	 * @param {String}            alignmentType
	 *                            String defining the relationship type
	 * @param {EcPpk}             owner
	 *                            Private Key that will own the relationship created
	 * @param {String}            server
	 *                            URL Prefix of the new relationship (Server it will be saved on)
	 * @param {Callback1<String>} success
	 *                            Callback triggered after successfully creating and saving the relationship
	 * @param {Callback1<String>} [failure]
	 *                            Callback triggered if error creating and saving relationship
	 * @return EcAlignment
	 * Created relationship
	 * @memberOf EcCompetency
	 * @method addAlignment
	 */
	public EcAlignment addAlignment(EcCompetency target, final String alignmentType, final EcPpk owner,
	                                final String serverUrl, Callback1<String> success, Callback1<String> failure,EcRepository repo) {
		final EcAlignment a = new EcAlignment();
		if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
			a.generateId(serverUrl);
		else
			a.generateShortId(serverUrl);
		a.source = shortId();
		a.target = target.shortId();
		a.relationType = alignmentType;
		a.addOwner(owner.toPk());

		a.save(success,failure,repo);

		return a;
	}

	/**
	 * Searches the repository given for any relationships that contain this competency
	 *
	 * @param {EcRepository}                  repo
	 *                                        Repository to search for relationships
	 * @param {Callback1<EcAlignment>}        eachSuccess
	 *                                        Callback triggered for each relationship found
	 * @param {Callback1<String>}             failure
	 *                                        Callback triggered if an error finding relationships
	 * @param {Callback1<Array<EcAlignment>>} successAll
	 *                                        Callback triggered once all of the relationships have been found
	 * @memberOf EcCompetency
	 * @method relations
	 */
	public void relations(EcRepository repo, final Callback1<EcAlignment> eachSuccess, final Callback1<String> failure,
	                      final Callback1<Array<EcAlignment>> successAll) {
		relationships(repo, eachSuccess, failure, successAll);
	}

	/**
	 * Searches the repository given for any relationships that contain this competency
	 *
	 * @param {EcRepository}                  repo
	 *                                        Repository to search for relationships
	 * @param {Callback1<EcAlignment>}        eachSuccess
	 *                                        Callback triggered for each relationship found
	 * @param {Callback1<String>}             failure
	 *                                        Callback triggered if an error finding relationships
	 * @param {Callback1<Array<EcAlignment>>} successAll
	 *                                        Callback triggered once all of the relationships have been found
	 * @memberOf EcCompetency
	 * @method relations
	 * @deprecated
	 */
	@Deprecated
	public void relationships(EcRepository repo, final Callback1<EcAlignment> eachSuccess, final Callback1<String> failure,
	                          final Callback1<Array<EcAlignment>> successAll) {
		EcAlignment.search(repo, "source:\"" + id + "\" OR target:\"" + id + "\" OR source:\"" + shortId() + "\" OR target:\"" + shortId() + "\"", new Callback1<Array<EcAlignment>>() {
			@Override
			public void $invoke(Array<EcAlignment> results) {
				for (int i = 0;i < results.$length();i++)
					eachSuccess.$invoke(results.$get(i));
				successAll.$invoke(results);
			}
		}, failure,new Object());
	}

	/**
	 * Adds a new level on the server specified for this competency.
	 *
	 * @param {String}            name
	 *                            Name of the new level to create
	 * @param {String}            description
	 *                            Description of the new level to create
	 * @param {String}            owner
	 *                            Private key of the owner of the new level
	 * @param {String}            server
	 *                            URL Prefix for the new level's ID (Server saved on)
	 * @param {Callback1<String>} success
	 *                            Callback triggered after successfully creating and saving the level
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error creating and saving the level
	 * @return EcLevel
	 * Level created
	 * @memberOf EcCompetency
	 * @method addLevel
	 */
	public EcLevel addLevel(String name, String description, final EcPpk owner, final String serverUrl, Callback1<String> success, Callback1<String> failure,EcRepository repo) {
		final EcLevel l = new EcLevel();
		if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
			l.generateId(serverUrl);
		else
			l.generateShortId(serverUrl);
		l.competency = shortId();
		l.description = description;
		l.name = name;
		l.addOwner(owner.toPk());

		l.save(success,failure,repo);

		return l;
	}

	/**
	 * Searches the repository given for any levels of this competency
	 *
	 * @param {EcRepository}              repo
	 *                                    Repository to search for levels
	 * @param {Callback1<EcLevel>}        success
	 *                                    Callback triggered for each level found
	 * @param {Callback1<String>}         failure
	 *                                    Callback triggered if an error finding levels
	 * @param {Callback1<Array<EcLevel>>} successAll
	 *                                    Callback triggered once all of the levels have been found
	 * @memberOf EcCompetency
	 * @method levels
	 */
	public void levels(EcRepository repo, final Callback1<EcLevel> eachSuccess, final Callback1<String> failure, final Callback1<Array<EcLevel>> successAll) {
		String query = "competency:\"" + id + "\" OR competency:\"" + shortId() + "\"";

		EcLevel.search(repo,query,new Callback1<Array<EcLevel>>() {
			@Override
			public void $invoke(Array<EcLevel> results) {
				for (int i = 0;i < results.$length();i++)
					eachSuccess.$invoke(results.$get(i));
				successAll.$invoke(results);
			}
		},failure,new Object());
	}

	/**
	 * Adds a new rollup rule on the server specified for this competency
	 *
	 * @param {String}            name
	 *                            Name of the rollup rule to create
	 * @param {String}            description
	 *                            Description of the rollup rule to create
	 * @param {EcPpk}             owner
	 *                            Private key that will own the new rollup rule
	 * @param {String}            server
	 *                            URL Prefix for the new rollup rule's ID (Server that it will be saved on)
	 * @param {Callback1<String>} success
	 *                            Callback triggered if successfully save the rollup rule
	 * @param {Callback1<String>} failure
	 *                            Callback triggered fi error during save of rollup rule
	 * @return EcRollupRule
	 * Created rollup rule
	 * @memberOf EcCompetency
	 * @method addRollupRule
	 */
	public EcRollupRule addRollupRule(String name, String description, final EcPpk owner, final String serverUrl, Callback1<String> success,
	                                  Callback1<String> failure, EcRepository repo) {
		final EcRollupRule r = new EcRollupRule();
		if (repo == null)

			if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
				r.generateId(serverUrl);
			else
				r.generateShortId(serverUrl);
		r.competency = shortId();
		r.description = description;
		r.name = name;
		r.addOwner(owner.toPk());

		r.save(success,failure,repo);

		return r;
	}

	/**
	 * Searches the repository given for any rollup rules of this competency
	 *
	 * @param {EcRepository}                  repo
	 *                                        Repository to search for levels
	 * @param {Callback1<EcRollupRule>}       success
	 *                                        Callback triggered for each rollup rule found
	 * @param {Callback1<String>}             failure
	 *                                        Callback triggered if an error finding rollup rule
	 * @param {Callback1<Array<EcRollupRule>} successAll
	 *                                        Callback triggered once all of the rollup rules have been found
	 * @memberOf EcCompetency
	 * @method rollupRules
	 */
	public void rollupRules(EcRepository repo, final Callback1<EcRollupRule> eachSuccess, final Callback1<String> failure,
	                        final Callback1<Array<EcRollupRule>> successAll) {
		String query = "competency:\"" + id + "\" OR competency:\"" + shortId() + "\"";

		EcRollupRule.search(repo,query,new Callback1<Array<EcRollupRule>>() {
			@Override
			public void $invoke(Array<EcRollupRule> results) {
				for (int i = 0;i < results.$length();i++)
					eachSuccess.$invoke(results.$get(i));
				successAll.$invoke(results);
			}
		},failure,new Object());
	}

	/**
	 * Method to set competency scope
	 *
	 * @param {String} scope
	 *                 Scope to set for its competency
	 * @memberOf EcCompetency
	 * @method setScope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * Saves the competency details to the server
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully saving the competency
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error saving competency
	 * @memberOf EcCompetency
	 * @method save
	 */
	public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
		if (this.name == null || this.name == "") {
			String msg = "Competency Name can not be empty";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}
		if (repo == null)
			EcRepository.save(this, success, failure);
		else
			repo.saveTo(this,success,failure);
	}

	/**
	 * Deletes the competency from the server
	 * <p>
	 * TODO: Delete rollup rules?
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successful deleting the competency
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error deleting the competency
	 * @param {EcRepository}      repo
	 *                            Repository to delete from and to check for levels or relationships to delete
	 * @memberOf EcCompetency
	 * @method _delete
	 */
	public void _delete(final Callback1<String> success, final Callback1<String> failure, final EcRepository repo) {
		final EcCompetency me = this;
		EcRepository.DELETE(this, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				if (repo != null) {
					me.relationships(repo, new Callback1<EcAlignment>() {
						@Override
						public void $invoke(EcAlignment p1) {
							for (int i = 0; i < EcIdentityManager.ids.$length(); i++) {
								if (p1.canEdit(EcIdentityManager.ids.$get(i).ppk.toPk())) {
									p1._delete(null, new Callback1<String>() {
										@Override
										public void $invoke(String p1) {
											if (failure != null)
												failure.$invoke("Unable to Delete Competency Relation");
											else
												Global.console.error("Unable to Delete Competency Relation");
										}
									});
									return;
								}
							}
						}
					}, failure, new Callback1<Array<EcAlignment>>() {
						@Override
						public void $invoke(Array<EcAlignment> p1) {
							if (levelDone.$get(id)) {
								if (success != null)
									success.$invoke("");
							} else {
								relDone.$put(id, true);
							}
						}
					});

					me.levels(repo, new Callback1<EcLevel>() {

						@Override
						public void $invoke(EcLevel p1) {
							for (int i = 0; i < EcIdentityManager.ids.$length(); i++) {
								if (p1.canEdit(EcIdentityManager.ids.$get(i).ppk.toPk())) {
									p1._delete(null, new Callback1<String>() {
										@Override
										public void $invoke(String p1) {
											if (failure != null)
												failure.$invoke("Unable to Delete Competency Relation");
											else
												Global.console.error("Unable to Delete Competency Relation");
										}
									});
									return;
								}
							}
						}

					}, failure, new Callback1<Array<EcLevel>>() {
						@Override
						public void $invoke(Array<EcLevel> p1) {
							if (relDone.$get(id)) {
								if (success != null)
									success.$invoke("");
							} else {
								levelDone.$put(id, true);
							}
						}
					});
				} else {
					if (success != null)
						success.$invoke(p1);
				}
			}
		}, failure);
	}
}
