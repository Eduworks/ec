package org.cass.importer;

import com.eduworks.ec.task.Task;
import js.FileReader;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.repository.EcRepository;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Import methods to handle an ASN JSON file containing a framework,
 * competencies and relationships, and store them in a CASS instance
 *
 * @author devlin.junker@eduworks.com
 * @author fritz.ray@eduworks.com
 * @module org.cassproject
 * @class ASNImport
 * @static
 * @extends Importer
 */
public class ASNImport extends Importer {

	private final static int INCREMENTAL_STEP = 5;

	static Object jsonFramework;
	static String frameworkUrl;

	static Map<String, Object> jsonCompetencies;

	static int competencyCount;
	static int relationCount;
	static EcFramework importedFramework;
	static Map<String, EcCompetency> competencies;
	static Object progressObject;
	static int savedCompetencies = 0;
	static int savedRelations = 0;

	/**
	 * Recursive function that looks through the file and saves each
	 * competency object in a map for use during importing. It also counts
	 * the number of competencies and relationships that it finds
	 *
	 * @param {Object} obj
	 *                 The current JSON object we're examining for comepetencies and reationships
	 * @param {String} key
	 *                 The ASN identifier of the current object
	 * @memberOf ASNImport
	 * @method asnJsonPrime
	 * @private
	 * @static
	 */
	private static void asnJsonPrime(Object obj, String key) {
		Object value = JSObjectAdapter.$get(obj, key);

		if (isObject(value)) {
			if (JSObjectAdapter.$get(value, "http://www.w3.org/1999/02/22-rdf-syntax-ns#type") != null) {
				Object stringVal = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(value, "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), "0"), "value");
				if (stringVal == "http://purl.org/ASN/schema/core/Statement") {
					jsonCompetencies.$put(key, value);
					competencyCount++;
					Array<Object> children = (Array<Object>) JSObjectAdapter.$get(value, "http://purl.org/gem/qualifiers/hasChild");
					if (children != null)
						for (int j = 0; j < children.$length(); j++) {
							relationCount++;
							asnJsonPrime(obj, (String) JSObjectAdapter.$get(children.$get(j), "value"));
						}
				}
			}
		}
	}

	/**
	 * Does the actual legwork of looking for competencies and relationships.
	 * <p>
	 * This function finds the framework information, and pulls out the competency
	 * objects array to be scanned by asnJsonPrime
	 *
	 * @param {Object} obj
	 *                 ASN JSON Object from file that contains framework information and competencies/relationships
	 * @memberOf ASNImport
	 * @method lookThroughSource
	 * @private
	 * @static
	 */
	private static void lookThroughSource(Object obj) {
		competencyCount = 0;
		relationCount = 0;
		for (String key : JSObjectAdapter.$properties(obj)) {
			Object value = JSObjectAdapter.$get(obj, key);
			if (isObject(value)) {
				if (JSObjectAdapter.$get(value, "http://www.w3.org/1999/02/22-rdf-syntax-ns#type") != null) {
					Object stringVal = JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(value, "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), "0"), "value");
					if (stringVal == "http://purl.org/ASN/schema/core/StandardDocument") {
						jsonFramework = value;
						frameworkUrl = key;
						Array<Object> children = (Array<Object>) JSObjectAdapter.$get(value, "http://purl.org/gem/qualifiers/hasChild");
						if (children != null)
							for (int j = 0; j < children.$length(); j++) {
								asnJsonPrime(obj, (String) JSObjectAdapter.$get(children.$get(j), "value"));
							}
					}
				}
			}
		}
	}

	/**
	 * Analyzes an ASN File for competencies and relationships.
	 * <p>
	 * This should be called before import, the success callback returns an object
	 * indicating the number of competencies and relationships found.
	 *
	 * @param {Object}            file
	 *                            ASN JSON file
	 * @param {Callback1<Object>} success
	 *                            Callback triggered on successful analysis of file
	 * @param {Callback1<Object>} [failure]
	 *                            Callback triggered if there is an error during analysis of the file
	 * @memberOf ASNImport
	 * @method analyzeFile
	 * @static
	 */
	public static void analyzeFile(Object file, final Callback1<Object> success, final Callback1<Object> failure) {
		if (file == null) {
			failure.$invoke("No file to analyze");
			return;
		}

		if (JSObjectAdapter.$get(file, "name") == null) {
			failure.$invoke("Invalid file");
			return;
		} else if (!((String) JSObjectAdapter.$get(file, "name")).endsWith(".json")) {
			failure.$invoke("Invalid file type");
			return;
		}

		FileReader reader = new FileReader();

		reader.onload = new Callback1<Object>() {
			@Override
			public void $invoke(Object e) {
				String result = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(e, "target"), "result");

				Object jsonObj = Global.JSON.parse(result);

				jsonCompetencies = JSCollections.$map();
				jsonFramework = null;
				frameworkUrl = "";

				lookThroughSource(jsonObj);

				if (jsonFramework == null) {
					failure.$invoke("Could not find StandardDocument.");
				} else {
					success.$invoke(jsonCompetencies);
				}
			}
		};

		reader.readAsText(file, "UTF-8");
	}

	/**
	 * Method to import the competencies from an ASN JSON file,
	 * should be called after analyzing the file
	 *
	 * @param {String}                        serverUrl
	 *                                        URL Prefix for the competencies to be imported
	 * @param {EcIdentity}                    owner
	 *                                        EcIdentity that will own the new competencies
	 * @param {boolean}                       createFramework
	 *                                        Flag to create a framework and include the competencies and relationships created
	 * @param {Callback2<Array<EcCompetency>, EcFramework>} success
	 *                                        Callback triggered after the competencies (and framework?) are created
	 * @param {Callback1<Object>}             failure
	 *                                        Callback triggered if an error occurs while creating the competencies
	 * @param {Callback1<Object>}             [incremental]
	 *                                        Callback triggered incrementally during the creation of competencies to indicate progress,
	 *                                        returns an object indicating the number of competencies (and relationships?) created so far
	 * @memberOf ASNImport
	 * @method importCompetencies
	 * @static
	 */
	public static void importCompetencies(final String serverUrl, final EcIdentity owner, final boolean createFramework,
	                                      final Callback2<Array<EcCompetency>, EcFramework> success, final Callback1<Object> failure,
	                                      final Callback1<Object> incremental, final EcRepository repo) {
		competencies = JSCollections.$map();
		if (createFramework) {
			importedFramework = new EcFramework();
			importedFramework.competency = JSCollections.$array();
			importedFramework.relation = JSCollections.$array();
		} else {
			importedFramework = null;
		}

		progressObject = null;

		createCompetencies(serverUrl, owner, new Callback0() {
			@Override
			public void $invoke() {
				createRelationships(serverUrl, owner, jsonFramework, null, new Callback0() {
					@Override
					public void $invoke() {
						if (createFramework) {
							createFramework(serverUrl, owner, success, failure, repo);
						} else {
							Array<EcCompetency> compList = JSCollections.$array();
							for (String key : competencies) {
								compList.push(competencies.$get(key));
							}

							if (success != null)
								success.$invoke(compList, null);
						}
					}
				}, failure, incremental, repo);
			}
		}, failure, incremental, repo);

	}

	/**
	 * Handles creating the competencies found during analysis, iterates through the
	 * competency ASN objects saved and creates them in the CASS repository at the URL given.
	 *
	 * @param {String}            serverUrl
	 *                            URL Prefix for the competencies to be imported
	 * @param {EcIdentity}        owner
	 *                            EcIdentity that will own the new competencies
	 * @param {Callback0}         success
	 *                            Callback triggered after the competencies are created
	 * @param {Callback1<Object>} failure
	 *                            Callback triggered if an error occurs while creating the competencies
	 * @param {Callback1<Object>} [incremental]
	 *                            Callback triggered incrementally during the creation of competencies to indicate progress
	 * @memberOf ASNImport
	 * @method createCompetencies
	 * @private
	 * @static
	 */
	private static void createCompetencies(String serverUrl, EcIdentity owner, final Callback0 success,
	                                       final Callback1<Object> failure, final Callback1<Object> incremental, EcRepository repo) {
		savedCompetencies = 0;

		for (String key : jsonCompetencies) {
			EcCompetency comp = new EcCompetency();
			Object jsonComp = jsonCompetencies.$get(key);

			if (JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/elements/1.1/title") == null)
				comp.name = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/terms/description"), "0"), "value");
			else
				comp.name = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/elements/1.1/title"), "0"), "value");

			if (JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/terms/description") != null)
				comp.description = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonComp, "http://purl.org/dc/terms/description"), "0"), "value");

			comp.id = key;
			if (comp.id == null) {
				if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
					comp.generateId(serverUrl);
				else
					comp.generateShortId(serverUrl);
			}

			if (owner != null)
				comp.addOwner(owner.ppk.toPk());

			if (importedFramework != null)
				importedFramework.addCompetency(comp.shortId());

			competencies.$put(key, comp);

			saveCompetency(success, failure, incremental, comp, repo);
		}
	}

	private static void saveCompetency(final Callback0 success, final Callback1<Object> failure, final Callback1<Object> incremental, final EcCompetency comp, final EcRepository repo) {
		Task.asyncImmediate(new Callback1() {
			@Override
			public void $invoke(Object o) {
				final Callback0 keepGoing = (Callback0) o;
				comp.save(new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						savedCompetencies++;

						if (savedCompetencies % INCREMENTAL_STEP == 0) {
							if (progressObject == null)
								progressObject = new Object();

							JSObjectAdapter.$put(progressObject, "competencies", savedCompetencies);

							incremental.$invoke(progressObject);
						}

						if (savedCompetencies == competencyCount) {
							if (progressObject == null)
								progressObject = new Object();

							JSObjectAdapter.$put(progressObject, "competencies", savedCompetencies);
							incremental.$invoke(progressObject);

							success.$invoke();
						}
						keepGoing.$invoke();
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						failure.$invoke("Failed to save competency");
						keepGoing.$invoke();
					}
				}, repo);
			}
		});
	}

	/**
	 * Handles creating the relationships from the file analyzed earlier.
	 * Recursively travels through looking for the hasChild field and creates
	 * relationships based off of that.
	 *
	 * @param {String}            serverUrl
	 *                            URL Prefix for the relationships to be imported
	 * @param {EcIdentity}        owner
	 *                            EcIdentity that will own the new relationships
	 * @param {Object}            node
	 * @param {String}            nodeId
	 * @param {Callback0}         success
	 *                            Callback triggered after the relationships are created
	 * @param {Callback1<Object>} failure
	 *                            Callback triggered if an error occurs while creating the relationships
	 * @param {Callback1<Object>} incremental
	 *                            Callback triggered incrementally during the creation of relationships to indicate progress
	 * @memberOf ASNImport
	 * @method createRelationships
	 * @private
	 * @static
	 */
	private static void createRelationships(String serverUrl, EcIdentity owner, Object node, String nodeId,
	                                        final Callback0 success, final Callback1<Object> failure, final Callback1<Object> incremental, EcRepository repo) {
		savedRelations = 0;

		if (relationCount == 0) {
			success.$invoke();
		}

		Array<Object> children = (Array<Object>) JSObjectAdapter.$get(node, "http://purl.org/gem/qualifiers/hasChild");
		if (children != null)
			for (int j = 0; j < children.$length(); j++) {
				if (nodeId != null) {
					EcAlignment relation = new EcAlignment();

					relation.target = competencies.$get(nodeId).id;
					relation.source = competencies.$get((String) JSObjectAdapter.$get(children.$get(j), "value")).id;

					relation.relationType = "narrows";
					relation.name = "";
					relation.description = "";
					if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
						relation.generateId(serverUrl);
					else
						relation.generateShortId(serverUrl);

					if (owner != null)
						relation.addOwner(owner.ppk.toPk());

					if (importedFramework != null)
						importedFramework.addRelation(relation.shortId());

					saveRelation(success, failure, incremental, relation,repo);
				}

				createRelationships(serverUrl, owner,
						jsonCompetencies.$get((String) JSObjectAdapter.$get(children.$get(j), "value")),
						(String) JSObjectAdapter.$get(children.$get(j), "value"),
						success, failure, incremental, repo
				);
			}
	}

	private static void saveRelation(final Callback0 success, final Callback1<Object> failure, final Callback1<Object> incremental, final EcAlignment relation, final EcRepository repo) {
		Task.asyncImmediate(new Callback1() {
			@Override
			public void $invoke(Object o) {
				final Callback0 keepGoing = (Callback0) o;
				relation.save(new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						savedRelations++;

						if (savedRelations % INCREMENTAL_STEP == 0) {
							if (progressObject == null)
								progressObject = new Object();

							JSObjectAdapter.$put(progressObject, "relations", savedRelations);

							incremental.$invoke(progressObject);
						}

						if (savedRelations == relationCount) {
							success.$invoke();
						}
						keepGoing.$invoke();
					}
				}, new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						failure.$invoke("Failed to save Relationship");
						keepGoing.$invoke();
					}
				}, repo);
			}
		});
	}


	/**
	 * Handles creating the framework if the createFramework flag was set
	 *
	 * @param {String}                        serverUrl
	 *                                        URL Prefix for the framework to be imported
	 * @param {EcIdentity}                    owner
	 *                                        EcIdentity that will own the new framework
	 * @param {Callback2<Array<EcCompetency>, EcFramework>} success
	 *                                        Callback triggered after the framework is created
	 * @param {Callback1<Object>}             failure
	 *                                        Callback triggered if there is an error during the creation of framework
	 * @meberOf ASNImport
	 * @method createFramework
	 * @private
	 * @static
	 */
	private static void createFramework(String serverUrl, EcIdentity owner, final Callback2<Array<EcCompetency>, EcFramework> success, final Callback1<Object> failure, EcRepository repo) {
		importedFramework.name = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonFramework, "http://purl.org/dc/elements/1.1/title"), "0"), "value");

		importedFramework.description = (String) JSObjectAdapter.$get(JSObjectAdapter.$get(JSObjectAdapter.$get(jsonFramework, "http://purl.org/dc/terms/description"), "0"), "value");

		importedFramework.id = frameworkUrl;
		if (importedFramework.id == null) {
			if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
				importedFramework.generateId(serverUrl);
			else
				importedFramework.generateShortId(serverUrl);
		}

		if (owner != null)
			importedFramework.addOwner(owner.ppk.toPk());

		importedFramework.save(new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				Array<EcCompetency> compList = JSCollections.$array();
				for (String key : competencies) {
					compList.push(competencies.$get(key));
				}

				if (success != null)
					success.$invoke(compList, importedFramework);
			}
		}, new Callback1<String>() {
			@Override
			public void $invoke(String p1) {
				failure.$invoke("Failed to save framework");
			}
		}, repo);
	}
}
