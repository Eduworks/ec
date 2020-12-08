package org.cass.importer;

import com.eduworks.ec.array.EcArray;
import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.crypto.EcPpk;
import js.Papa;
import js.PapaParseParams;
import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cassproject.ebac.identity.EcIdentity;
import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.cass.competency.Relation;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.*;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.functions.Callback3;

import static org.stjs.javascript.JSGlobal.typeof;

public class CTDLASNCSVImport {

	public static void analyzeFile(Object file, final Callback2<Integer, Integer> success, final Callback1<Object> failure) {

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
				encoding = "UTF-8";
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Array<String>> tabularData = (Array<Array<String>>) JSObjectAdapter.$get(results, "data");

						Array<String> colNames = tabularData.$get(0);

						Object nameToCol = new Object();
						for (int i = 0; i < colNames.$length(); i++)
							JSObjectAdapter.$put(nameToCol, colNames.$get(i), i);

						int frameworkCounter = 0;
						int competencyCounter = 0;
						Integer typeCol = (Integer) JSObjectAdapter.$get(nameToCol, "@type");
						if (typeCol == null) {
							error.$invoke("No @type in CSV.");
							return;
						}
						for (int i = 0; i < tabularData.$length(); i++) {
							if (i == 0) continue;
							Array<String> col = tabularData.$get(i);
							if (col.$get(typeCol) != null && col.$get(typeCol).trim() == "ceasn:CompetencyFramework")
								frameworkCounter++;
							else if (col.$get(typeCol) != null && col.$get(typeCol).trim() == "ceasn:Competency")
								competencyCounter++;
							else if (col.$get(typeCol) == null || col.$get(typeCol) == "")
								continue;
							else {
								error.$invoke("Found unknown type:" + col.$get(typeCol));
								return;
							}
						}
						success.$invoke(frameworkCounter, competencyCounter);
					}
				};
				error = failure;
			}
		});
	}

	public static void importFrameworksAndCompetencies(final EcRepository repo, Object file, final Callback3<Array<EcFramework>, Array<EcCompetency>, Array<EcAlignment>> success, final Callback1<Object> failure, final EcIdentity ceo, final String endpoint) {

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
				header = true;
				encoding = "UTF-8";
				complete = new Callback1<Object>() {
					@Override
					public void $invoke(Object results) {
						Array<Object> tabularData = (Array<Object>) JSObjectAdapter.$get(results, "data");

						final Object frameworks = new Object();
						final Array frameworkArray = new Array<EcFramework>();
						final Object frameworkRows = new Object();
						final Array competencies = new Array<EcCompetency>();
						final Object competencyRows = new Object();
						final Array relations = new Array<EcAlignment>();
						final Object relationById = new Object();
						new EcAsyncHelper<Object>().each(tabularData, new Callback2<Object, Callback0>() {
							@Override
							public void $invoke(final Object pretranslatedE, final Callback0 callback0) {
								if (JSObjectAdapter.$get(pretranslatedE, "@type") == "ceasn:CompetencyFramework") {
									EcLinkedData translator = new EcLinkedData(null, null);
									translator.copyFrom(pretranslatedE);
									cleanUpTranslator(translator, endpoint, repo);

									translator.recast("https://schema.cassproject.org/0.4/ceasn2cass", "https://schema.cassproject.org/0.4", new Callback1<EcLinkedData>() {
										@Override
										public void $invoke(EcLinkedData e) {
											EcFramework f = new EcFramework();
											f.copyFrom(e);
											if (EcFramework.template != null && JSObjectAdapter.$get(EcFramework.template, "@owner") != null) {
												JSObjectAdapter.$put(f, "owner", JSObjectAdapter.$get(EcFramework.template, "@owner"));
											}
											if (JSObjectAdapter.$get(e, "owner") != null) {
												EcIdentity id = new EcIdentity();
												id.ppk = EcPpk.fromPem((String) JSObjectAdapter.$get(e, "owner"));
												f.addOwner(id.ppk.toPk());
												EcIdentityManager.addIdentityQuietly(id);
											}
											if (ceo != null)
												f.addOwner(ceo.ppk.toPk());

											if (EcFramework.template != null && JSObjectAdapter.$get(EcFramework.template,("schema:dateCreated")) != null) {
												setDateCreated(e, f);
											}


											JSObjectAdapter.$put(frameworks, f.shortId(), f);
											JSObjectAdapter.$put(frameworkRows, f.shortId(), e);
											JSObjectAdapter.$put(f, "ceasn:hasChild", null);
											JSObjectAdapter.$put(f, "ceasn:hasTopChild", null);
											frameworkArray.push(f);
											f.competency = new Array();
											f.relation = new Array();
											//Delete ceasn:hasTopChild, ceasn:isChildOf, ceasn:hasChild, etc.
											callback0.$invoke();
										}
									}, (Callback1) failure);
								} else if (JSObjectAdapter.$get(pretranslatedE, "@type") == "ceasn:Competency") {
									EcLinkedData translator = new EcLinkedData(null, null);
									translator.copyFrom(pretranslatedE);
									cleanUpTranslator(translator, endpoint, repo);
									translator.recast("https://schema.cassproject.org/0.4/ceasn2cass", "https://schema.cassproject.org/0.4", new Callback1<EcLinkedData>() {
										@Override
										public void $invoke(EcLinkedData e) {
											EcCompetency f = new EcCompetency();
											f.copyFrom(e);
											if (JSObjectAdapter.$get(e, "id") == null) {
												callback0.$invoke();
												return;
											}
											if (JSObjectAdapter.$get(e, "ceasn:isPartOf") != null) {
												((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).competency.push(f.shortId());
											} else {
												Object parent = e;
												boolean done = false;
												while (!done && parent != null) {
													if (JSObjectAdapter.$get(parent, "ceasn:isChildOf") != null && JSObjectAdapter.$get(parent, "ceasn:isChildOf") != "") {
														parent = JSObjectAdapter.$get(competencyRows, (String) JSObjectAdapter.$get(parent, "ceasn:isChildOf"));
													} else if (JSObjectAdapter.$get(parent, "ceasn:isTopChildOf") != null && JSObjectAdapter.$get(parent, "ceasn:isTopChildOf") != "") {
														parent = JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(parent, "ceasn:isTopChildOf"));
														done = true;
													}
												}
												if (!done) {
													failure.$invoke("Could not find framework:" + JSObjectAdapter.$get(e, "type"));
													return;
												}
												if (parent != null) {
													if (JSObjectAdapter.$get(parent, "type") == "Framework") {
														JSObjectAdapter.$put(e, "ceasn:isPartOf", EcRemoteLinkedData.trimVersionFromUrl((String) JSObjectAdapter.$get(parent, "id")));
														((EcFramework) JSObjectAdapter.$get(frameworks, EcRemoteLinkedData.trimVersionFromUrl((String) JSObjectAdapter.$get(parent, "id")))).competency.push(f.shortId());
													} else {
														failure.$invoke("Object cannot trace to framework:" + JSObjectAdapter.$get(e, "type"));
														return;
													}
												} else {
													failure.$invoke("Object has no framework:" + JSObjectAdapter.$get(e, "type"));
													return;
												}
											}

											if (EcCompetency.template != null && JSObjectAdapter.$get(EcCompetency.template, "@owner") != null) {
												JSObjectAdapter.$put(f, "owner", JSObjectAdapter.$get(EcCompetency.template, "@owner"));
											}

											if (JSObjectAdapter.$get(e, "owner") == null) {
												if (JSObjectAdapter.$get(JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf")), "owner") != null)
													JSObjectAdapter.$put(e, "owner", JSObjectAdapter.$get(JSObjectAdapter.$get(frameworkRows, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf")), "owner"));
											}
											EcIdentity id = new EcIdentity();
											if (JSObjectAdapter.$get(e, "owner") != null) {
												id.ppk = EcPpk.fromPem((String) JSObjectAdapter.$get(e, "owner"));
												if (id.ppk != null)
													f.addOwner(id.ppk.toPk());
												EcIdentityManager.addIdentityQuietly(id);
											}
											if (ceo != null)
												f.addOwner(ceo.ppk.toPk());

											if (EcCompetency.template != null && JSObjectAdapter.$get(EcCompetency.template,("schema:dateCreated")) != null) {
												setDateCreated(e, f);
											}

											//isChildOf does not have multiple values
											if (JSObjectAdapter.$get(e, "ceasn:isChildOf") != null) {
												createEachRelation(e, "ceasn:isChildOf", Relation.NARROWS, repo, ceo, id, relations, relationById, frameworks, -1, endpoint);
											}
											if (JSObjectAdapter.$get(e, "ceasn:broadAlignment") != null) {
												createRelations(e, "ceasn:broadAlignment", Relation.NARROWS, repo, ceo, id, relations, relationById, frameworks, endpoint);
											}
											if (JSObjectAdapter.$get(e, "ceasn:narrowAlignment") != null) {
												createRelations(e, "ceasn:narrowAlignment", Relation.NARROWS, repo, ceo, id, relations, relationById, frameworks, endpoint);
											}
											if (JSObjectAdapter.$get(e, "sameAs") != null) {
												createRelations(e, "sameAs", Relation.IS_EQUIVALENT_TO, repo, ceo, id, relations, relationById, frameworks, endpoint);
											}
											if (JSObjectAdapter.$get(e, "ceasn:majorAlignment") != null) {
												createRelations(e, "ceasn:majorAlignment", "majorRelated", repo, ceo, id, relations, relationById, frameworks, endpoint);
											}
											if (JSObjectAdapter.$get(e, "ceasn:minorAlignment") != null) {
												createRelations(e, "ceasn:minorAlignment", "minorRelated", repo, ceo, id, relations, relationById, frameworks, endpoint);
											}
											if (JSObjectAdapter.$get(e, "ceasn:prerequisiteAlignment") != null) {
												createRelations(e, "ceasn:prerequisiteAlignment", Relation.REQUIRES, repo, ceo, id, relations, relationById, frameworks, endpoint);
											}
											JSObjectAdapter.$put(f, "ceasn:isTopChildOf", null);
											JSObjectAdapter.$put(f, "ceasn:isChildOf", null);
											JSObjectAdapter.$put(f, "ceasn:isPartOf", null);
											JSObjectAdapter.$put(f, "ceasn:broadAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:narrowAlignment", null);
											//Translation of ceasn:exactAlignment
											JSObjectAdapter.$put(f, "sameAs", null);
											JSObjectAdapter.$put(f, "ceasn:majorAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:minorAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:prerequisiteAlignment", null);
											JSObjectAdapter.$put(f, "ceasn:hasChild", null);
											competencies.push(f);
											JSObjectAdapter.$put(competencyRows, f.shortId(), e);
											callback0.$invoke();
										}
									}, (Callback1) failure);
								} else if (JSObjectAdapter.$get(pretranslatedE, "@type") == null || JSObjectAdapter.$get(pretranslatedE, "@type") == "")
								{callback0.$invoke();return;}

								else {
									failure.$invoke("Found unknown type:" + JSObjectAdapter.$get(pretranslatedE, "@type"));
									callback0.$invoke();
									return;
								}
							}
						}, new Callback1<Array<Object>>() {
							@Override
							public void $invoke(Array<Object> strings) {
								success.$invoke(frameworkArray, competencies, relations);
							}
						});
					}
				};
				error = failure;
			}
		});
	}

	private static String getIdFromCtid(String ctid, String endpoint, EcRepository repo, String context, String type, String key) {
		if (key != "id") {
			if (key == "ceasn:isPartOf" || key == "ceasn:isTopChildOf") {
				if (type == "Competency") {
					type = "Framework";
				} else if (type == "Concept") {
					type = "ConceptScheme";
				}
			} else {
				if (type == "Framework") {
					type = "Competency";
				} else if (type == "ConceptScheme") {
					type = "Concept";
				}
			}
		}
		if (endpoint != null) {
			if (endpoint.indexOf("ce-") != -1) {
				ctid = ctid.substring(3);
			}
			return endpoint + ctid;
		} else {
			ctid = ctid.substring(3);
			EcRemoteLinkedData obj = new EcRemoteLinkedData(context, type);
			obj.assignId(repo.selectedServer, ctid);
			if (key == "id") {
				return obj.id;
			} else {
				return obj.shortId();
			}
		}
	}

	static void cleanUpTranslator(EcLinkedData translator, String endpoint, EcRepository repo) {
		String context = null;
		String type = null;
		if (JSObjectAdapter.$get(translator, "type") == "ceasn:CompetencyFramework") {
			context = "https://schema.cassproject.org/0.4/";
			type = "Framework";
		} else if (JSObjectAdapter.$get(translator, "type") == "ceasn:Competency") {
			context = "https://schema.cassproject.org/0.4/";
			type = "Competency";
		} else if (JSObjectAdapter.$get(translator, "type") == "ceasn:ConceptScheme") {
			context = "https://schema.cassproject.org/0.4/skos/";
			type = "ConceptScheme";
		} else if (JSObjectAdapter.$get(translator, "type") == "ceasn:Concept") {
			context = "https://schema.cassproject.org/0.4/skos/";
			type = "Concept";
		}
		for (String key : JSObjectAdapter.$properties(translator)) {
			if (JSObjectAdapter.$get(translator, key) == "") {
				JSObjectAdapter.$put(translator, key, null);
			}
			else if (JSObjectAdapter.$get(translator, key) != null){
				Object thisKey = JSObjectAdapter.$get(translator, key);
				if (typeof(thisKey) == "string") {
					//If it's only whitespace, remove value
					if (((String)JSObjectAdapter.$get(translator, key)).trim().length() == 0) {
						JSObjectAdapter.$put(translator, key, null);
					}
					//If multiple values, split string into an array
					else if (((String)thisKey).indexOf("|") != -1) {
						thisKey = ((String)thisKey).split("|");
						JSObjectAdapter.$put(translator, key, thisKey);
						//Remove whitespace from piped values
						for (int i = 0; i < ((Array<String>)thisKey).$length(); i++) {
							if (((Array<String>)thisKey).$get(i) != ((Array<String>)thisKey).$get(i).trim()) {
								String thisVal = ((Array<String>)thisKey).$get(i).trim();
								((Array<String>)thisKey).$set(i, thisVal);
							}
						}
					} else if (((String) thisKey).startsWith("ce-") && key != "ceterms:ctid") {
						String id = getIdFromCtid((String) thisKey, endpoint, repo, context, type, key);
						JSObjectAdapter.$put(translator, key, id);
					}
				} else if (EcArray.isArray(thisKey)) {
					for (int i = 0; i < ((Array<String>)thisKey).$length(); i++) {
						if (typeof(((Array<String>)thisKey).$get(i)) == "string" && ((String) ((Array<String>)thisKey).$get(i)).startsWith("ce-")) {
							String id = getIdFromCtid((String) ((Array<String>)thisKey).$get(i), endpoint, repo, context, type, key);
							((Array<String>)thisKey).$set(i, id);
						}
					}
				}
				//Strip whitespace from keys
				if (key != key.trim()) {
					String trimKey = key.trim();
					JSObjectAdapter.$put(translator, trimKey, JSObjectAdapter.$get(translator, key));
					JSObjectAdapter.$put(translator, key, null);
				}
			}
		}
	}

	static void createRelations(EcLinkedData e, String field, String type, EcRepository repo, EcIdentity ceo, EcIdentity id, Array relations, Object relationById, Object frameworks, String endpoint) {
		if (!EcArray.isArray(JSObjectAdapter.$get(e, field))) {
			Array<String> makeArray = JSGlobal.Array((String)JSObjectAdapter.$get(e, field));
			JSObjectAdapter.$put(e, field, makeArray);
		}
		for (int i = 0; i < ((Array<String>)JSObjectAdapter.$get(e, field)).$length(); i++) {
			createEachRelation(e, field, type, repo, ceo, id, relations, relationById, frameworks, i, endpoint);
		}
	}

	static void createEachRelation(EcLinkedData e, String field, String type, EcRepository repo, EcIdentity ceo, EcIdentity id, Array relations, Object relationById, Object frameworks, int i, String endpoint) {
		EcAlignment r = new EcAlignment();
		if (endpoint != null) {
			r.generateShortId(endpoint);
		} else {
			r.generateId(repo.selectedServer);
		}
		if (ceo != null)
			r.addOwner(ceo.ppk.toPk());
		if (id.ppk != null)
			r.addOwner(id.ppk.toPk());

		r.relationType = type;
		if (field == "ceasn:narrowAlignment") {
			String sourceId = ((Array<String>)JSObjectAdapter.$get(e, field)).$get(i);
			if (sourceId.startsWith("ce-")) {
				sourceId = getIdFromCtid(sourceId, endpoint, repo, "https://schema.cassproject.org/0.4/", "Competency", field);
			}
			r.source = EcRemoteLinkedData.trimVersionFromUrl(sourceId);
			r.target = EcRemoteLinkedData.trimVersionFromUrl((String) JSObjectAdapter.$get(e, "id"));
		}
		else {
			r.source = EcRemoteLinkedData.trimVersionFromUrl((String) JSObjectAdapter.$get(e, "id"));
			if (i != -1) {
				String targetId = ((Array<String>) JSObjectAdapter.$get(e, field)).$get(i);
				if (targetId.startsWith("ce-")) {
					targetId = getIdFromCtid(targetId, endpoint, repo, "https://schema.cassproject.org/0.4/", "Competency", field);
				}
				r.target = EcRemoteLinkedData.trimVersionFromUrl(targetId);
			}
			//i = -1 if field is not an array
			else {
				String targetId = ((String) JSObjectAdapter.$get(e, field));
				if (targetId.startsWith("ce-")) {
					targetId = getIdFromCtid(targetId, endpoint, repo, "https://schema.cassproject.org/0.4/", "Competency", field);
				}
				r.target = EcRemoteLinkedData.trimVersionFromUrl(targetId);
			}
		}

		relations.push(r);
		JSObjectAdapter.$put(relationById, r.shortId(), r);
		((EcFramework) JSObjectAdapter.$get(frameworks, (String) JSObjectAdapter.$get(e, "ceasn:isPartOf"))).relation.push(r.shortId());
	}

	public static void setDateCreated(EcLinkedData importObject, EcRemoteLinkedData object) {
		if (JSObjectAdapter.$get(importObject, "ceasn:dateCreated") == null && JSObjectAdapter.$get(importObject, "schema:dateCreated") == null) {
			Integer timestamp = object.getTimestamp();
			String date;
			if (timestamp != null) {
				date = new Date(JSGlobal.parseInt(timestamp)).toISOString();
			} else {
				date = new Date().toISOString();
			}
			JSObjectAdapter.$put(object, "schema:dateCreated", date);
		}
	}
}
