package org.cass.competency;

import com.eduworks.ec.crypto.EcPpk;
import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.Cass;
import org.cassproject.schema.cass.competency.Level;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;

/**
 * Implementation of a Level object with methods for interacting with CASS
 * services on a server.
 *
 * @author fritz.ray@eduworks.com
 * @author devlin.junker@eduworks.com
 * @module org.cassproject
 * @class EcLevel
 * @constructor
 * @extends Level
 */
public class EcLevel extends Level {
	/**
	 * Retrieves a level from the server specified by its ID
	 *
	 * @param {String}             id
	 *                             ID of the level to retrieve
	 * @param {Callback1<EcLevel>} success
	 *                             Callback triggered when successfully retrieving the level,
	 *                             returns the level
	 * @param {Callback1<String>}  failure
	 *                             Callback triggered if error occurs when retrieving the level
	 * @memberOf EcLevel
	 * @method get
	 * @static
	 */
	public static void get(String id, final Callback1<EcLevel> success, final Callback1<String> failure) {
		EcRepository.get(id, new Callback1<EcRemoteLinkedData>() {
			@Override
			public void $invoke(EcRemoteLinkedData p1) {
				EcLevel level = new EcLevel();

				if (p1.isA(EcEncryptedValue.myType)) {
					EcEncryptedValue encrypted = new EcEncryptedValue();
					encrypted.copyFrom(p1);
					p1 = encrypted.decryptIntoObject();

					EcEncryptedValue.encryptOnSave(p1.id, true);
				}
				if (p1.isAny(level.getTypes())) {
					level.copyFrom(p1);

					if (success != null)
						success.$invoke(level);
				} else {
					String msg = "Resultant object is not a level.";
					if (failure != null)
						failure.$invoke(msg);
					else
						Global.console.error(msg);
				}
			}
		}, failure);
	}

	/**
	 * Retrieves a level from it's server synchronously, the call
	 * blocks until it is successful or an error occurs
	 *
	 * @param {String} id
	 *                 ID of the level to retrieve
	 * @return EcLevel
	 * The level retrieved
	 * @memberOf EcLevel
	 * @method getBlocking
	 * @static
	 */
	public static EcLevel getBlocking(String id) {
		EcRemoteLinkedData p1 = EcRepository.getBlocking(id);
		if (p1 == null)
			return null;
		EcLevel level = new EcLevel();

		if (p1.isA(EcEncryptedValue.myType)) {
			EcEncryptedValue encrypted = new EcEncryptedValue();
			encrypted.copyFrom(p1);
			p1 = encrypted.decryptIntoObject();

			EcEncryptedValue.encryptOnSave(p1.id, true);
		}
		if (p1.isAny(level.getTypes())) {
			level.copyFrom(p1);

			return level;
		} else {
			String msg = "Retrieved object was not a level";
			Global.console.error(msg);
			return null;
		}
	}

	/**
	 * Searches for levels with a string query
	 *
	 * @param {EcRepository}              repo
	 *                                    Repository to search for levels
	 * @param {String}                    query
	 *                                    query string to use in search
	 * @param {Callback1<Array<EcLevel>>} success
	 *                                    Callback triggered when searches successfully
	 * @param {Callback1<String>}         failure
	 *                                    Callback triggered if an error occurs while searching
	 * @param {Object}                    paramObj
	 *                                    Search parameters object to pass in
	 * @memberOf EcLevel
	 * @method search
	 * @static
	 */
	public static void search(EcRepository repo, String query, final Callback1<Array<EcLevel>> success, Callback1<String> failure, Object paramObj) {
		String queryAdd = "";
		queryAdd = new EcLevel().getSearchStringByType();

		if (query == null || query == "")
			query = queryAdd;
		else
			query = "(" + query + ") AND " + queryAdd;

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {
			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcLevel> ret = JSCollections.$array();
					for (int i = 0; i < p1.$length(); i++) {
						EcLevel level = new EcLevel();
						if (p1.$get(i).isAny(level.getTypes())) {
							level.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcLevel.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								level.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(level.id, true);
							}
						}

						ret.$set(i, level);
					}

					success.$invoke(ret);
				}
			}

		}, failure);
	}

	/**
	 * Searches for levels using a competency that the results must be related to
	 *
	 * @param {EcRepository}              repo
	 *                                    Repository to search for levels
	 * @param {String}                    competencyId
	 *                                    competency ID that the levels are rleated to
	 * @param {Callback1<Array<EcLevel>>} success
	 *                                    Callback triggered when searches successfully
	 * @param {Callback1<String>}         failure
	 *                                    Callback triggered if an error occurs while searching
	 * @param {Object}                    paramObj
	 *                                    Search parameters object to pass in
	 * @memberOf EcLevel
	 * @method searchByCompetency
	 * @static
	 */
	public static void searchByCompetency(EcRepository repo, final String competencyId, final Callback1<Array<EcLevel>> success, Callback1<String> failure, Object paramObj) {
		if (competencyId == null || competencyId == "") {
			failure.$invoke("No Competency Specified");
			return;
		}

		String query = "(" + new EcLevel().getSearchStringByType();

		query += " AND ( competency:\"" + competencyId + "\" OR competency:\"" + EcRemoteLinkedData.trimVersionFromUrl(competencyId) + "\"))";

		query += " OR @encryptedType:\"" + EcLevel.myType + "\" OR @encryptedType:\"" + EcLevel.myType.replace(Cass.context + "/", "") + "\"";

		repo.searchWithParams(query, paramObj, null, new Callback1<Array<EcRemoteLinkedData>>() {

			@Override
			public void $invoke(Array<EcRemoteLinkedData> p1) {
				if (success != null) {
					Array<EcLevel> levels = JSCollections.$array();

					for (int i = 0; i < p1.$length(); i++) {
						EcLevel level = new EcLevel();

						if (p1.$get(i).isAny(level.getTypes())) {
							level.copyFrom(p1.$get(i));
						} else if (p1.$get(i).isA(EcEncryptedValue.myType)) {
							EcEncryptedValue val = new EcEncryptedValue();
							val.copyFrom(p1.$get(i));
							if (val.isAnEncrypted(EcLevel.myType)) {
								EcRemoteLinkedData obj = val.decryptIntoObject();
								if (JSObjectAdapter.$get(obj, "competency") != competencyId) {
									continue;
								}
								level.copyFrom(obj);
								EcEncryptedValue.encryptOnSave(level.id, true);
							}
						}
						level.copyFrom(p1.$get(i));
						levels.$set(i, level);
					}

					if (success != null)
						success.$invoke(levels);
				}
			}

		}, failure);
	}

	/**
	 * Adds a relationship between this level and a target level to define
	 * how they correspond to one another
	 *
	 * @param {EcLevel} targetLevel
	 *                  Target level of the relationship
	 * @param {String}  alignmentType
	 *                  Type of relationship
	 * @param {EcPpk}   identity
	 *                  Private key that will own the new relationship
	 * @param {String}  server
	 *                  URL Prefix of the new relationship ID (Server it will be saved on)
	 * @memberOf EcLevel
	 * @method addRelationship
	 */
	public void addRelationship(EcLevel targetLevel, String alignmentType, final EcPpk identity, final String serverUrl, Callback1<String> success, Callback1<String> failure, final EcRepository repo) {
		final EcAlignment a = new EcAlignment();
		a.source = id;
		a.target = targetLevel.id;
		a.relationType = alignmentType;
		a.addOwner(identity.toPk());
		if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
			a.generateId(serverUrl);
		else
			a.generateShortId(serverUrl);
		a.signWith(identity);
		a.save(success, failure, repo);
	}

	/**
	 * Method to set the name of this level
	 *
	 * @param {String} name
	 *                 Name to set on the level
	 * @memberOf EcLevel
	 * @method setName
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to set the description of the level
	 *
	 * @param {String} description
	 *                 Description to set on the level
	 * @memberOf EcLevel
	 * @method setDescription
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Saves this levels details to the server
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered on successfully saving the level to the server
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if error occurs while saving the level to the server
	 * @memberOf EcLevel
	 * @method save
	 */
	public void save(Callback1<String> success, Callback1<String> failure, EcRepository repo) {
		if (name == null || name == "") {
			String msg = "Level name cannot be empty";
			if (failure != null)
				failure.$invoke(msg);
			else
				Global.console.error(msg);
			return;
		}

		if (competency == null || competency == "") {
			String msg = "Level's Competency cannot be empty";
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
	 * Deletes the level from it's repository
	 *
	 * @param {Callback1<String>} success
	 *                            Callback triggered when the level is successfully deleted from the server
	 * @param {Callback1<String>} failure
	 *                            Callback triggered if an error occurs while deleting the level
	 * @memberOf EcLevel
	 * @method _delete
	 */
	public void _delete(Callback1<String> success, Callback1<String> failure) {
		EcRepository.DELETE(this, success, failure);
	}
}
