package org.cass.importer;

import com.eduworks.ec.array.EcObject;
import com.eduworks.ec.task.Task;
import js.Papa;
import js.PapaParseParams;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

/**
 * Import methods to handle an CSV file of competencies and a
 * CSV file of relationships and store them in a CASS instance
 *
 * @author devlin.junker@eduworks.com
 * @author fritz.ray@eduworks.com
 * @module org.cassproject
 * @class CSVImport
 * @static
 * @extends Importer
 */
public class CSVImport {
	private final static int INCREMENTAL_STEP = 5;
	static Object importCsvLookup;
	static int saved;
	static Object progressObject;

	/**
	 * Analyzes a CSV File to return the column names to the user for specifying
	 * which columns contain which data. This should be called before import.
	 *
	 * @param {Object}            file
	 *                            CSV file to be analyzed
	 * @param {Callback1<Object>} success
	 *                            Callback triggered after successfully analyzing the CSV file
	 * @param {Callback1<Object>} [failure]
	 *                            Callback triggered if there is an error analyzing the CSV file
	 * @memberOf CSVImport
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
		} else if (!((String) JSObjectAdapter.$get(file, "name")).endsWith(".csv")) {
			failure.$invoke("Invalid file type");
		}

		Papa.parse(file, new PapaParseParams() {
			{
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Object tabularData = JSObjectAdapter.$get(results, "data");
						success.$invoke(tabularData);
					}
				};
				error = failure;
			}
		});
	}

	/**
	 * Helper function to transform a competencies oldID to match the new server url
	 *
	 * @param {String}             oldId
	 *                             Old ID found in the CSV file
	 * @param {EcRemoteLinkedData} newObject
	 *                             New competency being created
	 * @param {String}             selectedServer
	 *                             New URL Prefix that the new competency's ID should match
	 * @memberOf CSVImport
	 * @method transformId
	 * @private
	 * @static
	 */
	private static void transformId(String oldId, EcRemoteLinkedData newObject, String selectedServer,EcRepository repo) {
		if (oldId == null || oldId == "" || oldId.indexOf("http") == -1)
			newObject.assignId(selectedServer, oldId);
		else {
			if (EcCompetency.getBlocking(oldId) == null)
				newObject.id = oldId;
			else {
				if (repo == null || repo.selectedServer.indexOf(selectedServer) != -1)
					newObject.generateId(selectedServer);
				else
					newObject.generateShortId(selectedServer);
			}
		}
	}

	/**
	 * Method to create competencies (and relationships if the parameters are passed in)
	 * based on a CSV file and references to which columns correspond to which pieces
	 * of data.
	 *
	 * @param {Object}                        file
	 *                                        CSV File to import competencies from
	 * @param {String}                        serverUrl
	 *                                        URL Prefix for the created competencies (and relationships?)
	 * @param {EcIdentity}                    owner
	 *                                        EcIdentity that will own the created competencies (and relationships?)
	 * @param {int}                           nameIndex
	 *                                        Index of the column that contains the competency names
	 * @param {int}                           descriptionIndex
	 *                                        Index of the column that contains the competency descriptions
	 * @param {int}                           scopeIndex
	 *                                        Index of the column that contains the competency scopes
	 * @param {int}                           idIndex
	 *                                        Index of the column that contains the old competency ID (Optional, if not exists pass null or negative)
	 * @param {Object}                        [relations]
	 *                                        CSV File to import relationships from (Optional, if not exists pass null)
	 * @param {int}                           [sourceIndex]
	 *                                        Index (in relation file) of the column containing the relationship source competency ID (Optional, if not exists pass null or negative)
	 * @param {int}                           [relationTypeIndex]
	 *                                        Index (in relation file) of the column containing the relationship type (Optional, if not exists pass null or negative)
	 * @param {int}                           [destIndex]
	 *                                        Index (in relation file) of the column containing the relationship destination competency ID (Optional, if not exists pass null or negative)
	 * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
	 *                                        Callback triggered after the competencies (and relationships?) have been created
	 * @param {Callback1<Object>}             [failure]
	 *                                        Callback triggered if an error during creating the competencies
	 * @param {Callback1<Object>}             [incremental]
	 *                                        Callback triggered incrementally during creation of competencies to indicate progress,
	 *                                        returns an object indicating the number of competencies (and relationships?) created so far
	 * @memberOf CSVImport
	 * @method importCompetencies
	 * @static
	 */
	public static void importCompetencies(Object file, final String serverUrl, final EcIdentity owner,
	                                      final Integer nameIndex, final Integer descriptionIndex, final Integer scopeIndex, final Integer idIndex,
	                                      final Object relations, final Integer sourceIndex, final Integer relationTypeIndex, final Integer destIndex,
	                                      final Callback2<Array<EcCompetency>, Array<EcAlignment>> success, final Callback1<Object> failure,
	                                      final Callback1<Object> incremental, final Boolean uniquify, final EcRepository repo) {
		progressObject = null;
		importCsvLookup = new Object();
		if (nameIndex < 0) {
			failure.$invoke("Name Index not Set");
			return;
		}

		final Array<EcCompetency> competencies = JSCollections.$array();
		Papa.parse(file, new PapaParseParams() {
			{
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						Array<String> colNames = tabularData.$get(0);

						for (int i = 1; i < tabularData.$length(); i++) {
							// If empty row then skip
							if (tabularData.$get(i).$length() == 0 ||
									(tabularData.$get(i).$length() == 1 &&
											(tabularData.$get(i).$get(0) == null || tabularData.$get(i).$get(0) == JSGlobal.undefined || tabularData.$get(i).$get(0) == ""))) {
								continue;
							}
							// If name empty, skip row
							if (tabularData.$get(i).$get(nameIndex) == null || tabularData.$get(i).$get(nameIndex) == JSGlobal.undefined
									|| tabularData.$get(i).$get(nameIndex) == "") {
								continue;
							}

							EcCompetency competency = new EcCompetency();

							// Basic info
							competency.name = tabularData.$get(i).$get(nameIndex);
							if (descriptionIndex >= 0)
								competency.description = tabularData.$get(i).$get(descriptionIndex);
							if (scopeIndex >= 0)
								competency.scope = tabularData.$get(i).$get(scopeIndex);

							// If not unique and IdIndex set, copy GUID from CSV but prepend our serverUrl
							if ((uniquify == JSGlobal.undefined || uniquify == null || uniquify == false) && idIndex != null && idIndex >= 0) {
								competency.id = tabularData.$get(i).$get(idIndex);
								transformId(tabularData.$get(i).$get(idIndex), competency, serverUrl,repo);
								// otherwise (unique or no idIndex), generate new ID
							} else {
								if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
									competency.generateId(serverUrl);
								else
									competency.generateShortId(serverUrl);
							}

							// Set owner if we are given one
							if (owner != JSGlobal.undefined && owner != null)
								competency.addOwner(owner.ppk.toPk());

							// Build a map from old competency identifiers (oldShortId, oldId and name) to the next competency ID
							// 	Used if we are importing relationships 
							String shortId = null;
							if (idIndex != null && idIndex != JSGlobal.undefined && idIndex >= 0) {
								String oldId = tabularData.$get(i).$get(idIndex);
								shortId = EcRemoteLinkedData.trimVersionFromUrl(oldId);
								JSObjectAdapter.$put(importCsvLookup, shortId, competency.shortId());
							}
							if (idIndex != null && idIndex != JSGlobal.undefined && idIndex >= 0 && tabularData.$get(i).$get(idIndex) != null && tabularData.$get(i).$get(idIndex) != "") {
								if (JSObjectAdapter.$get(importCsvLookup, tabularData.$get(i).$get(idIndex)) == null)
									JSObjectAdapter.$put(importCsvLookup, tabularData.$get(i).$get(idIndex), competency.shortId());
							}

							// Copy extraneous fields in CSV 
							for (int idx = 0; idx < tabularData.$get(i).$length(); idx++) {
								String name = colNames.$get(idx);
								// ignore empty header columns, or @-columns
								if (name == null || name.trim() == "" || name.startsWith("@") || name.indexOf(".") != -1 || tabularData.$get(i).$get(idx).trim() == "" ||
										idx == nameIndex || idx == descriptionIndex || idx == scopeIndex || idx == idIndex) {
									continue;
								} else {
									JSObjectAdapter.$put(competency, colNames.$get(idx), tabularData.$get(i).$get(idx));
								}
							}

							competencies.push(competency);
						}

						// Save Competencies after list is built from CSV
						saved = 0;
						for (int i = 0; i < competencies.$length(); i++) {
							EcCompetency comp = competencies.$get(i);
							saveCompetency(comp, incremental, competencies, relations, success, serverUrl, owner, sourceIndex, relationTypeIndex, destIndex, failure, repo);
						}
					}
				};
				error = failure;
			}
		});
	}

	public static void saveCompetency(final EcCompetency comp, final Callback1<Object> incremental, final Array<EcCompetency> competencies, final Object relations, final Callback2<Array<EcCompetency>, Array<EcAlignment>> success, final String serverUrl, final EcIdentity owner, final Integer sourceIndex, final Integer relationTypeIndex, final Integer destIndex, final Callback1<Object> failure, final EcRepository repo) {
		Task.asyncImmediate(new Callback1() {
			@Override
			public void $invoke(Object o) {
				final Callback0 keepGoing = (Callback0) o;
				comp.save(new Callback1<String>() {
					public void $invoke(String results) {
						saved++;

						if (saved % INCREMENTAL_STEP == 0) {
							if (progressObject == null)
								progressObject = new Object();
							JSObjectAdapter.$put(progressObject, "competencies", saved);

							incremental.$invoke(progressObject);
						}

						if (saved == competencies.$length()) {
							if (relations == null)
								success.$invoke(competencies, new Array<EcAlignment>());
							else
								importRelations(serverUrl, owner, relations, sourceIndex, relationTypeIndex,
										destIndex, competencies, success, failure, incremental, repo);
						}
						keepGoing.$invoke();
					}

				}, new Callback1<String>() {
					public void $invoke(String results) {
						failure.$invoke("Failed to save competency");

						for (int j = 0; j < competencies.$length(); j++) {
							competencies.$get(j)._delete(null, null, null);
						}
						keepGoing.$invoke();
					}
				}, repo);
			}
		});
	}

	/**
	 * Handles actually importing the relationships from the relationship CSV file
	 *
	 * @param {String}                        serverUrl
	 *                                        URL Prefix for the created competencies (and relationships?)
	 * @param {EcIdentity}                    owner
	 *                                        EcIdentity that will own the created competencies (and relationships?)
	 * @param {Object}                        file
	 *                                        CSV File to import competencies from
	 * @param {int}                           sourceIndex
	 *                                        Index (in relation file) of the column containing the relationship source competency ID
	 * @param {int}                           relationTypeIndex
	 *                                        Index (in relation file) of the column containing the relationship type
	 * @param {int}                           destIndex
	 *                                        Index (in relation file) of the column containing the relationship destination competency ID
	 * @param {Array<EcCompetency>}           competencies
	 *                                        Array of newly created competencies
	 * @param {Callback2<Array<EcCompetency>, Array<EcAlignment>>} success
	 *                                        Callback triggered after the relationships have been created
	 * @param {Callback1<Object>}             failure
	 *                                        Callback triggered if an error during creating the relationships
	 * @param {Callback1<Object>}             incremental
	 *                                        Callback triggered incrementally during creation to indicate progress
	 * @memberOf CSVImport
	 * @method importRelations
	 * @private
	 * @static
	 */
	private static void importRelations(final String serverUrl, final EcIdentity owner, Object file,
	                                    final Integer sourceIndex, final Integer relationTypeIndex, final Integer destIndex,
	                                    final Array<EcCompetency> competencies, final Callback2<Array<EcCompetency>, Array<EcAlignment>> success,
	                                    final Callback1<Object> failure, final Callback1<Object> incremental, final EcRepository repo) {
		final Array<EcAlignment> relations = new Array<>();

		if (sourceIndex == null || sourceIndex < 0) {
			failure.$invoke("Source Index not Set");
			return;
		}

		if (relationTypeIndex == null || relationTypeIndex < 0) {
			failure.$invoke("Relation Type Index not Set");
			return;
		}

		if (destIndex == null || destIndex < 0) {
			failure.$invoke("Destination Index not Set");
			return;
		}

		Papa.parse(file, new PapaParseParams() {
			{
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						for (int i = 1; i < tabularData.$length(); i++) {
							EcAlignment alignment = new EcAlignment();
							String sourceKey = tabularData.$get(i).$get(sourceIndex);
							String relationTypeKey = tabularData.$get(i).$get(relationTypeIndex);
							String destKey = tabularData.$get(i).$get(destIndex);
							if (JSObjectAdapter.$get(importCsvLookup, sourceKey) == null)
								alignment.source = sourceKey;
							else
								alignment.source = (String) JSObjectAdapter.$get(importCsvLookup, sourceKey);
							if (JSObjectAdapter.$get(importCsvLookup, destKey) == null)
								alignment.target = destKey;
							else
								alignment.target = (String) JSObjectAdapter.$get(importCsvLookup, destKey);
							alignment.relationType = relationTypeKey;
							if (owner != null)
								alignment.addOwner(owner.ppk.toPk());
							if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
								alignment.generateId(serverUrl);
							else
								alignment.generateShortId(serverUrl);

							relations.push(alignment);
						}

						saved = 0;
						for (int i = 0; i < relations.$length(); i++) {
							EcAlignment relation = relations.$get(i);
							saveRelation(relation, incremental, relations, success, competencies, failure, repo);
						}
						if (saved == 0 && saved == relations.$length()) {
							success.$invoke(competencies, relations);
						}
					}
				};
				error = failure;
			}
		});
	}

	public static void saveRelation(final EcAlignment relation, final Callback1<Object> incremental, final Array<EcAlignment> relations, final Callback2<Array<EcCompetency>, Array<EcAlignment>> success, final Array<EcCompetency> competencies, final Callback1<Object> failure, final EcRepository repo) {
		Task.asyncImmediate(new Callback1() {
			@Override
			public void $invoke(Object o) {
				final Callback0 keepGoing = (Callback0) o;
				relation.save(new Callback1<String>() {
					public void $invoke(String results) {
						saved++;

						if (saved % INCREMENTAL_STEP == 0) {
							if (progressObject == null)
								progressObject = new Object();

							JSObjectAdapter.$put(progressObject, "relations", saved);

							incremental.$invoke(progressObject);

							incremental.$invoke(saved);
						}

						if (saved == relations.$length()) {
							success.$invoke(competencies, relations);
						}
						keepGoing.$invoke();
					}

				}, new Callback1<String>() {
					public void $invoke(String results) {
						failure.$invoke("Failed to save competency or relation");

						for (int j = 0; j < competencies.$length(); j++) {
							competencies.$get(j)._delete(null, null, null);
						}
						for (int j = 0; j < relations.$length(); j++) {
							relations.$get(j)._delete(null, null);
						}
						keepGoing.$invoke();
					}
				}, repo);
			}
		});
	}

	private static int hasContextColumn(Array<String> colNames) {
		for (int idx = 0; idx < colNames.$length(); idx++) {
			if (colNames.$get(idx) == "@context") {
				return idx;
			}
		}

		return -1;
	}

	private static int hasTypeColumn(Array<String> colNames) {
		for (int idx = 0; idx < colNames.$length(); idx++) {
			if (colNames.$get(idx) == "@type") {
				return idx;
			}
		}

		return -1;
	}

	private static void expandObject(Array<String> nestedFields, Object nestedObj, Object value) {
		if (nestedFields.$length() == 0) {
			return;
		} else if (nestedFields.$length() == 1) {
			JSObjectAdapter.$put(nestedObj, nestedFields.$get(0), value);
		} else {
			String key = nestedFields.$get(0);
			if (JSObjectAdapter.$get(nestedObj, key) == null || JSObjectAdapter.$get(nestedObj, key) == JSGlobal.undefined)
				JSObjectAdapter.$put(nestedObj, key, new Object());
			nestedFields.splice(0, 1);
			expandObject(nestedFields, JSObjectAdapter.$get(nestedObj, key), value);
		}
	}

	public static void transformReferences(Object data) {
		Map<String, Object> props = JSObjectAdapter.$properties(data);
		for (String prop : props) {

			if (props.$get(prop) == null || props.$get(prop) == JSGlobal.undefined || com.eduworks.ec.array.toString.call(props.$get(prop)).indexOf("String") == -1) {
				if (EcObject.isObject(props.$get(prop))) {
					Object nested = props.$get(prop);
					transformReferences(nested);
					JSObjectAdapter.$put(data, prop, nested);
				}
				continue;
			}
			String oldVal = (String) props.$get(prop);
			if (JSObjectAdapter.$get(importCsvLookup, oldVal) != null && JSObjectAdapter.$get(importCsvLookup, oldVal) != JSGlobal.undefined &&
					JSObjectAdapter.$get(importCsvLookup, oldVal) != "") {
				JSObjectAdapter.$put(data, prop, JSObjectAdapter.$get(importCsvLookup, oldVal));
			}
		}
	}

	public static void importData(Object file, final String serverUrl, final EcIdentity owner,
	                              final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<Object> failure, final Callback1<Object> incremental,
	                              final Integer idIndex, final String assignedContext, final String assignedType, final EcRepository repo) {
		final Array<EcRemoteLinkedData> objects = JSCollections.$array();

		final boolean hasAssignedContext = assignedContext != JSGlobal.undefined && assignedContext != null && assignedContext.trim() != "";
		final boolean hasAssignedType = assignedType != JSGlobal.undefined && assignedType != null && assignedType.trim() != "";

		importCsvLookup = new Object();

		Papa.parse(file, new PapaParseParams() {
			{
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						Array<String> colNames = tabularData.$get(0);

						int contextIdx = -1;
						int typeIdx = -1;
						if (!hasAssignedContext && (contextIdx = hasContextColumn(colNames)) == -1) {
							failure.$invoke("Was not passed and cannot find column with data context");
						} else if (!hasAssignedType && (typeIdx = hasTypeColumn(colNames)) == 1) {
							failure.$invoke("Was not passed and cannot find column with data type");
						}

						for (int i = 1; i < tabularData.$length(); i++) {
							// Skip empty rows
							if (tabularData.$get(i).$length() == 0 ||
									(tabularData.$get(i).$length() == 1 &&
											(tabularData.$get(i).$get(0) == null || tabularData.$get(i).$get(0) == JSGlobal.undefined || tabularData.$get(i).$get(0) == ""))) {
								continue;
							}

							String context = null;
							String type = null;
							if (hasAssignedContext)
								context = assignedContext;
							else
								context = tabularData.$get(i).$get(contextIdx);
							if (hasAssignedType)
								type = assignedType;
							else
								type = tabularData.$get(i).$get(typeIdx);

							EcRemoteLinkedData data = new EcRemoteLinkedData(context, type);

							Map<String, Object> nestedObjs = JSCollections.$map();
							// Copy fields in CSV 
							for (int idx = 0; idx < tabularData.$get(i).$length(); idx++) {
								String name = colNames.$get(idx);
								// ignore empty header columns, or @-columns
								if (name == "@id" || name == "id") {
									data.id = tabularData.$get(i).$get(idx);
									continue;
								} else if (name == null || name.trim() == "" || name.startsWith("@") || tabularData.$get(i).$get(idx).trim() == "" ||
										idx == contextIdx || idx == typeIdx) {
									continue;
								} else if (name.indexOf(".") != -1) {
									Array<String> split = JSCollections.$castArray(name.split("."));
									if (split.$length() > 1) {
										String key = split.$get(0);
										if (nestedObjs.$get(key) == null || nestedObjs.$get(key) == JSGlobal.undefined)
											nestedObjs.$put(key, new Object());
										split.splice(0, 1);

										expandObject(split, nestedObjs.$get(key), tabularData.$get(i).$get(idx));

										continue;
									}
									name = split.$get(0);
								}

								String val = tabularData.$get(i).$get(idx);

								JSObjectAdapter.$put(data, name, val);
							}


							for (String key : nestedObjs) {
								JSObjectAdapter.$put(data, key, nestedObjs.$get(key));
							}

							if (owner != null)
								data.addOwner(owner.ppk.toPk());


							String fileId = data.id;
							if (idIndex != JSGlobal.undefined && idIndex != null && idIndex >= 0) {
								data.id = tabularData.$get(i).$get(idIndex);
								transformId(tabularData.$get(i).$get(idIndex), data, serverUrl,repo);
							} else {
								if (repo == null || repo.selectedServer.indexOf(serverUrl) != -1)
									data.generateId(serverUrl);
								else
									data.generateShortId(serverUrl);
							}

							String shortId;
							if (idIndex != null && idIndex != JSGlobal.undefined && idIndex >= 0) {
								String oldId = tabularData.$get(i).$get(idIndex);
								shortId = EcRemoteLinkedData.trimVersionFromUrl(oldId);
								JSObjectAdapter.$put(importCsvLookup, shortId, data.shortId());
							}
							if (idIndex != null && idIndex != JSGlobal.undefined && idIndex >= 0 && tabularData.$get(i).$get(idIndex) != null && tabularData.$get(i).$get(idIndex) != "") {
								if (JSObjectAdapter.$get(importCsvLookup, tabularData.$get(i).$get(idIndex)) == null)
									JSObjectAdapter.$put(importCsvLookup, tabularData.$get(i).$get(idIndex), data.shortId());
							} else if (fileId != null && fileId != JSGlobal.undefined && fileId != "") {
								if (JSObjectAdapter.$get(importCsvLookup, fileId) == null)
									JSObjectAdapter.$put(importCsvLookup, fileId, data.shortId());
								shortId = EcRemoteLinkedData.trimVersionFromUrl(fileId);
								if (JSObjectAdapter.$get(importCsvLookup, shortId) == null)
									JSObjectAdapter.$put(importCsvLookup, shortId, data.shortId());
							}
							objects.push(data);
						}

						saved = 0;
						for (int i = 0; i < objects.$length(); i++) {
							EcRemoteLinkedData data = objects.$get(i);

							transformReferences(data);

							saveTransformedData(data, incremental, objects, success, failure, repo);
						}
					}
				};
				error = failure;
			}
		});
	}

	public static void saveTransformedData(final EcRemoteLinkedData data, final Callback1<Object> incremental, final Array<EcRemoteLinkedData> objects, final Callback1<Array<EcRemoteLinkedData>> success, final Callback1<Object> failure, final EcRepository repo) {
		Task.asyncImmediate(new Callback1() {
			@Override
			public void $invoke(Object o) {
				final Callback0 keepGoing = (Callback0) o;
				Callback1<String> scs = new Callback1<String>() {
					public void $invoke(String results) {
						saved++;

						if (saved % INCREMENTAL_STEP == 0)
							incremental.$invoke(saved);
						if (saved == objects.$length())
							success.$invoke(objects);
						keepGoing.$invoke();
					}

				};
				Callback1<String> err = new Callback1<String>() {
					public void $invoke(String results) {
						failure.$invoke("Failed to save object");
						keepGoing.$invoke();
					}
				};
				if (repo == null)
					EcRepository.save(data, scs, err);
				else
					repo.saveTo(data, scs, err);
			}
		});
	}
}
